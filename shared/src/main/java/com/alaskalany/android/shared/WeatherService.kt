package com.alaskalany.android.shared

import com.alaskalany.android.shared.dto.ForecastDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {
    @GET("forecast/{key}/{latitude},{longitude}")
    suspend fun forecast(
        @Path("key")
        user: String,
        @Path("latitude")
        latitude: String,
        @Path("longitude")
        longitude: String
    ): Response<ForecastDto>
}