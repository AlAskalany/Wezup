package com.alaskalany.android.shared

import com.alaskalany.android.model.enums.DataBlock
import com.alaskalany.android.model.enums.ForecastLanguage
import com.alaskalany.android.model.enums.ForecastUnits
import com.alaskalany.android.shared.dto.ForecastDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {

    @GET("forecast/{key}/{latitude},{longitude}")
    suspend fun forecast(
        @Path("key")
        user: String,
        @Path("latitude")
        latitude: String,
        @Path("longitude")
        longitude: String,
        @Query("language")
        language: String = ForecastLanguage.ENGLISH.value,
        @Query("exclude")
        exclude: String = DataBlock.ALERTS.value,
        @Query("units")
        units: String = ForecastUnits.US.value
    ): Response<ForecastDto>
}