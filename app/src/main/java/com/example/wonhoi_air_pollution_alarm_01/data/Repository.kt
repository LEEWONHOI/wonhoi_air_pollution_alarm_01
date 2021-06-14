package com.example.wonhoi_air_pollution_alarm_01.data

import com.example.wonhoi_air_pollution_alarm_01.data.services.KakaoLocalApiservice
import com.example.wonhoi_air_pollution_alarm_01.BuildConfig
import com.example.wonhoi_air_pollution_alarm_01.data.models.airquality.MeasuredValue
import com.example.wonhoi_air_pollution_alarm_01.data.models.monitoringstation.MonitoringStation
import com.example.wonhoi_air_pollution_alarm_01.data.services.AirKoreaApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Repository {

    // lat, lon -> Tm data, This function is used in coroutine
    // documents is List<> type
    suspend fun getNearbyMonitoringStation(latitude : Double, longitude : Double) : MonitoringStation? {
        val tmCoordinate = kakaoLocalApiservice
            .getTmCoordinates(longitude, latitude)
            .body()
            ?.documents
            ?.firstOrNull()

        val tmX = tmCoordinate?.x
        val tmY = tmCoordinate?.y

        return airKoreaApiService
            .getNearbyMonitoringStation(tmX!!, tmY!!)   // make try catch
            .body()
            ?.response
            ?.body
            ?.monitoringStations
            ?.minByOrNull { it.tm ?: Double.MAX_VALUE }

    }

    suspend fun getLatestAirQualityData(stationName : String) : MeasuredValue? =
        airKoreaApiService
            .getRealtimeAirQualities(stationName)
            .body()
            ?.response
            ?.body
            ?.measuredValues
            ?.firstOrNull()


    private val kakaoLocalApiservice : KakaoLocalApiservice by lazy {
        Retrofit.Builder()
            .baseUrl(Url.KAKAO_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(buildHttpClient())
            .build()
            .create()   // create KakaoLocalApiservice::class.java
    }

    private val airKoreaApiService : AirKoreaApiService by lazy {
        Retrofit.Builder()
            .baseUrl(Url.AIR_KOREA_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(buildHttpClient())
            .build()
            .create()
    }


    private fun buildHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) { // for test
                        HttpLoggingInterceptor.Level.BODY
                    } else {
                        HttpLoggingInterceptor.Level.NONE
                    }
                }
            )
            .build()
}