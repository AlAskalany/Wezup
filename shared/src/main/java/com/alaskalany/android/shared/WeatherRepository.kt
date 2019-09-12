package com.alaskalany.android.shared

import com.alaskalany.android.model.data.Currently
import com.alaskalany.android.model.data.Forecast
import com.alaskalany.android.shared.mappers.CurrentlyMapper
import com.alaskalany.android.shared.mappers.ForecastMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepository(
    private val weatherService: WeatherService = NetworkClient.instance
) {

    suspend fun fetchForecast(user: String, latitude: String, longitude: String): Forecast? =
        withContext(Dispatchers.IO) {
            val response = weatherService.forecast(user, latitude, longitude)
            if (response.isSuccessful) {
                return@withContext ForecastMapper.map(response.body())
            } else {
                return@withContext null
            }
        }

    suspend fun fetchCurrently(user: String, latitude: String, longitude: String): Currently? =
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