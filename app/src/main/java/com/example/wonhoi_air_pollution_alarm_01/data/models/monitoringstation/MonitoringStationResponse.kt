package com.example.wonhoi_air_pollution_alarm_01.data.models.monitoringstation


import com.google.gson.annotations.SerializedName

data class MonitoringStationResponse(
    @SerializedName("response")
    val response: Response?
)