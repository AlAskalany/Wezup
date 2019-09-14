package com.alaskalany.android.shared

import android.util.Log
import com.alaskalany.android.model.data.Forecast
import com.alaskalany.android.model.data.period.CurrentlyData
import com.alaskalany.android.shared.mappers.CurrentlyMapper
import com.alaskalany.android.shared.mappers.ForecastMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepository(
    private val weatherService: WeatherService = NetworkClient.instance
) {

    suspend fun fetchForecast(user: String, latitude: String, longitude: String): Forecast? {
        val response = withContext(Dispatchers.IO) {
            try {
                weatherService.forecast(user, latitude, longitude)
            } catch (e: Exception) {
                Log.e("WeatherRepository", e.message, e)
                null
            }
        }
        return if (response?.isSuccessful == true) {
            ForecastMapper.map(response.body())
        } else {
            null
        }
    }

    suspend fun fetchCurrently(user: String, latitude: String, longitude: String): CurrentlyData? =
        withContext(Dispatchers.IO) {

            val response = weatherService.forecast(user, latitude, longitude)
            if (response.isSuccessful) {
                val forecastDto = response.body()
                if (forecastDto != null) {
                    return@withContext CurrentlyMapper.map(forecastDto.currently)
                } else {
                    return@withContext null
                }
            } else {
                return@withContext null
            }
        }
}