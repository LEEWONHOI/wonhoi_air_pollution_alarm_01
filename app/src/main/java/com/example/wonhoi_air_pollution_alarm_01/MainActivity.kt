package com.example.wonhoi_air_pollution_alarm_01

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.example.wonhoi_air_pollution_alarm_01.data.Repository
import com.example.wonhoi_air_pollution_alarm_01.data.models.airquality.Grade
import com.example.wonhoi_air_pollution_alarm_01.data.models.airquality.MeasuredValue
import com.example.wonhoi_air_pollution_alarm_01.data.models.monitoringstation.MonitoringStation
import com.example.wonhoi_air_pollution_alarm_01.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationTokenSource
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private var cancellationTokenSource: CancellationTokenSource? = null

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        bindViews()
        initVariables()
        // Request Permission
        requestLocationPermission()


    }

    override fun onDestroy() {
        super.onDestroy()
        cancellationTokenSource?.cancel()
        scope.cancel()
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        val locationPermissionGranted =
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

//        val backgroundLocationPermissionGranted =
//            requestCode == REQUEST_BACKGROUND_ACCESS_LOCATION_PERMISSIONS &&
//                    grantResults[0] == PackageManager.PERMISSION_GRANTED

        // request Background Location Information
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) { // android 11

            if (!locationPermissionGranted) {
                finish()
            } else {
                val backgroundLocationPermissionGranted =
                    ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_BACKGROUND_LOCATION
                    ) == PackageManager.PERMISSION_GRANTED

                    val shouldShowBackgroundPermissionRationale =
                        shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_BACKGROUND_LOCATION)

                if (!backgroundLocationPermissionGranted && shouldShowBackgroundPermissionRationale) {
                    showBackgroundLocationPermissionRationaleDialog()
                } else {
                    // PermissionGranted
                    fetchAirQualityData()
                }
            }

        } else {
            if (!locationPermissionGranted) {
                finish()
            } else {
                // PermissionGranted
                fetchAirQualityData()
            }
        }
    }


    // for Refresh Action
    private fun bindViews() {
        binding.refresh.setOnRefreshListener {
            fetchAirQualityData()
        }
    }


    // Location Data
    private fun initVariables() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ),
            REQUEST_ACCESS_LOCATION_PERMISSIONS
        )
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun requestBackgroundLocationPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
            ),
            REQUEST_BACKGROUND_ACCESS_LOCATION_PERMISSIONS
        )
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun showBackgroundLocationPermissionRationaleDialog() {
        AlertDialog.Builder(this)
            .setMessage("The Home widget requires ${packageManager.backgroundPermissionOptionLabel} location authority.")
            .setPositiveButton("Setting") {dialog, _ ->
                requestBackgroundLocationPermission()
                dialog.dismiss()
            }
            .setNegativeButton("Not to Use") {dialog, _ ->
                fetchAirQualityData()
                dialog.dismiss()
            }
            .show()
    }

    @SuppressLint("MissingPermission") // already permission checked -> requestLocationPermission
    private fun fetchAirQualityData() {
        cancellationTokenSource = CancellationTokenSource()

        fusedLocationProviderClient.getCurrentLocation(
            LocationRequest.PRIORITY_HIGH_ACCURACY, // This app requests location information only once
            cancellationTokenSource!!.token
            // ★ fusedLocationProviderClient is nullable (check FusedLocationProviderClient.getCurrentLocation Doc)
        ).addOnSuccessListener { location ->
            // When Api calls complete
            binding.errorDescriptionTextView.visibility = View.GONE
            scope.launch {
                try {
                    val monitoringStation =
                        Repository.getNearbyMonitoringStation(location.latitude, location.longitude)

                    val measuredValue =
                        Repository.getLatestAirQualityData(monitoringStation!!.stationName!!)

                    displayAirQualityData(monitoringStation, measuredValue!!)
                } catch (exception: Exception) { // Need to be improved later
                    exception.printStackTrace()
                    binding.errorDescriptionTextView.visibility = View.VISIBLE
                    binding.contentLayout.alpha = 0F
                } finally {
                    binding.progressBar.visibility = View.GONE
                    binding.refresh.isRefreshing = false
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun displayAirQualityData(monitoringStation: MonitoringStation, measuredValue: MeasuredValue) {

        binding.contentLayout.animate()
            .alpha(1F)
//          .duration()
            .start()

        binding.measuringStationNameTextView.text = monitoringStation.stationName
        binding.measuringStationAddressTextView.text = monitoringStation.addr

        // null check
        (measuredValue.khaiGrade ?: Grade.UNKWON).let { grade ->
            binding.root.setBackgroundResource(grade.colorRes)
            binding.totalGradeLabelTextView.text = grade.label
            binding.totalGradleEmojiTextView.text = grade.emoji
        }

        with(measuredValue) {

            binding.fineDustInformationTextView.text =
                "Find Dust : $pm10Value ㎍/m3 ${(pm10Grade ?: Grade.UNKWON).emoji}"

            binding.ultraFineDustInformationTextView.text =
                "Ultra Fine Dust : $pm25Value ${(pm25Grade ?: Grade.UNKWON).emoji}"

            with(binding.so2Item) {
                labelTextView.text = "Sulfur dioxide"
                gradeTextView.text = (so2Grade ?: Grade.UNKWON).toString()
                valueTextView.text = "$so2Value ppm"
            }

            with(binding.coItem) {
                labelTextView.text = "Carbon monoxide"
                gradeTextView.text = (coGrade ?: Grade.UNKWON).toString()
                valueTextView.text = "$coValue ppm"
            }

            with(binding.o3Item) {
                labelTextView.text = "Ozone"
                gradeTextView.text = (o3Grade ?: Grade.UNKWON).toString()
                valueTextView.text = "$o3Value ppm"
            }

            with(binding.no2Item) {
                labelTextView.text = "Nitrogen dioxide\n"
                gradeTextView.text = (no2Grade ?: Grade.UNKWON).toString()
                valueTextView.text = "$no2Value ppm"
            }
        }
    }

    companion object {
        private const val REQUEST_ACCESS_LOCATION_PERMISSIONS = 100
        private const val REQUEST_BACKGROUND_ACCESS_LOCATION_PERMISSIONS = 101

    }

}