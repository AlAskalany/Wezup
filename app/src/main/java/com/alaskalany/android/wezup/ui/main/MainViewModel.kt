package com.alaskalany.android.wezup.ui.main

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alaskalany.android.model.IDailyData
import com.alaskalany.android.model.IForecast
import com.alaskalany.android.shared.WeatherRepository
import kotlin.math.roundToInt

class MainViewModel : ViewModel() {

    private val weatherRepository: WeatherRepository = WeatherRepository()

    private val _temperatureLiveData: MutableLiveData<String> = MutableLiveData()

    val temperature: LiveData<String>
        get() = _temperatureLiveData

    private val _weatherDescriptionLiveData: MutableLiveData<String> = MutableLiveData()

    val weatherDescription: LiveData<String>
        get() = _weatherDescriptionLiveData

    private val _sunnyLiveData: MutableLiveData<Boolean> = MutableLiveData()

    private val _cloudyLiveData: MutableLiveData<Boolean> = MutableLiveData()

    private val _latitude: MutableLiveData<String> = MutableLiveData()

    private val _longitude: MutableLiveData<String> = MutableLiveData()

    private val _timeZoneLiveData: MutableLiveData<String> = MutableLiveData()

    val timeZone: LiveData<String>
        get() = _timeZoneLiveData

    private val _dailyLiveData: MutableLiveData<List<IDailyData?>?> = MutableLiveData()

    val daily: LiveData<List<IDailyData?>?>
        get() = _dailyLiveData

    private var _weatherIcon: MutableLiveData<String> = MutableLiveData()

    val weatherIcon: LiveData<String>
        get() = _weatherIcon

    init {
        _temperatureLiveData.value = "12"
        _weatherDescriptionLiveData.value = "Good Weather"
        _sunnyLiveData.value = true
        _cloudyLiveData.value = true
        _longitude.value = "-"
        _latitude.value = "-"
        _timeZoneLiveData.value = "-"
    }

    @MainThread
    fun setLatitude(text: String) {
        _latitude.value = text
    }

    @MainThread
    fun setLongitude(text: String) {
        _longitude.value = text
    }

    private suspend fun getForecast(latitude: String, longitude: String) {
        val forecast = weatherRepository.fetchForecast(
            "dafc50f09edd941ce1876d78a0a31b77",
            latitude,
            longitude
        )

        println(forecast)

        updateCurrently(forecast)
        updateDaily(forecast)
    }

    private fun updateDaily(forecast: IForecast?) {
        _dailyLiveData.value = forecast?.daily?.data
    }

    private fun updateCurrently(forecast: IForecast?) {
        val currently = forecast?.currently
        _weatherIcon.value = currently?.icon
        _weatherDescriptionLiveData.value = currently?.summary
        _timeZoneLiveData.value = forecast?.timezone?.replace("_", " ")
        _temperatureLiveData.value = forecast?.currently?.temperature?.roundToInt()?.toString()
    }

    suspend fun setLocation(
        lat: String,
        long: String
    ) {
        getForecast(lat, long)
    }
}
