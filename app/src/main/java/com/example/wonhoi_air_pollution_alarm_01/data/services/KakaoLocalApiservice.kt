package com.example.wonhoi_air_pollution_alarm_01.data.services

import com.example.wonhoi_air_pollution_alarm_01.data.models.tmcordinates.TmCoordinateResponse
import com.example.wonhoi_air_pollution_alarm_01.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

//  https://developers.kakao.com/docs/latest/en/local/dev-guide#trans-coord
//   GET /v2/local/geo/transcoord.{format} HTTP/1.1
//   Host: dapi.kakao.com
//   Authorization: KakaoAK {REST_API_KEY}

interface KakaoLocalApiservice {

    @Headers("Authorization: KakaoAK ${BuildConfig.KAKAO_API_KEY}")
    @GET("v2/local/geo/transcoord.json?output_coord=TM")
    suspend fun getTmCoordinates(
        @Query("x") longitude : Double,
        @Query("y") latitude : Double
    ) : Response<TmCoordinateResponse>
}