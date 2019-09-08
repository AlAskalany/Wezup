package com.alaskalany.android.shared

import com.alaskalany.android.model.ICurrently
import com.alaskalany.android.model.IForecast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepository(
    private val weatherService: WeatherService = NetworkClient.instance
) {
    suspend fun fetchForecast(user: String, latitude: String, longitude: String): IForecast? =
        withContext(Dispatchers.IO) {
            val response = weatherService.forecast(user, latitude, longitude)
            if (response.isSuccessful) {
                return@withContext response.body()
            } else {
                return@withContext null
            }
        }

    suspend fun fetchCurrently(user: String, latitude: String, longitude: String): ICurrently? =
        withContext(Dispatchers.IO) {

            val response = weatherService.forecast(user, latitude, longitude)
            if (response.isSuccessful) {
                val forecastDto = response.body()
                if (forecastDto != null) {
                    return@withContext forecastDto.currently as ICurrently?
                } else {
                    return@withContext null
                }
            } else {
                return@withContext null
            }
        }
}