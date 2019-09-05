package com.alaskalany.android.shared

import com.alaskalany.android.shared.dto.ForecastDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepository(
    private val weatherService: WeatherService = NetworkClient.instance
) {
    suspend fun fetchForecast(user: String, latitude: String, longitude: String): ForecastDto? =
        withContext(Dispatchers.IO) {
            val response = weatherService.forecast(user, latitude, longitude)
            if (response.isSuccessful) {
                return@withContext response.body()
            } else {
                return@withContext null
            }
        }
}