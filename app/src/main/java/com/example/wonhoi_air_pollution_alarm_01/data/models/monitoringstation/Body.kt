package com.example.wonhoi_air_pollution_alarm_01.data.models.monitoringstation


import com.example.wonhoi_air_pollution_alarm_01.data.models.monitoringstation.MonitoringStation
import com.google.gson.annotations.SerializedName

data class Body(
    @SerializedName("items")
    val monitoringStations: List<MonitoringStation>?,
    @SerializedName("numOfRows")
    val numOfRows: Int?,
    @SerializedName("pageNo")
    val pageNo: Int?,
    @SerializedName("totalCount")
    val totalCount: Int?
)