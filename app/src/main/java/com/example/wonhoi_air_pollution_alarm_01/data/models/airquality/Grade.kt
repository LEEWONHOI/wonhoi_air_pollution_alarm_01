package com.example.wonhoi_air_pollution_alarm_01.data.models.airquality

import android.graphics.Color
import androidx.annotation.ColorRes
import com.example.wonhoi_air_pollution_alarm_01.R
import com.google.gson.annotations.SerializedName

enum class Grade(
    val label: String,
    val emoji: String,
    @ColorRes val colorRes: Int
) {
    @SerializedName("1")
    GOOD("GOOD", "😊", R.color.blue),

    @SerializedName("2")
    NORMAL("NORMAL", "😃", R.color.green),

    @SerializedName("3")
    BAD("BAD", "😑", R.color.yellow),

    @SerializedName("4")
    AWFUL("AWFUL", "😷", R.color.red),

    UNKWON("UNKWON", "🧐", R.color.gray);

    override fun toString(): String {
        return "$label, $emoji"
    }

}