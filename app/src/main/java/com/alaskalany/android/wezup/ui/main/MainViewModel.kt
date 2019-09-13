package com.alaskalany.android.wezup.ui.main

import android.location.Location
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.alaskalany.android.model.data.period.DailyData
import com.alaskalany.android.model.data.Forecast
import com.alaskalany.android.model.enums.ForecastIcon
import com.alaskalany.android.shared.WeatherRepository

class MainViewModel : ViewModel() {

    private val weatherRepository: WeatherRepository = WeatherRepository()

    private val _temperatureLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val temperature: LiveData<String> = Transformations.map(_temperatureLiveData) {
        it
    }

    private val _weatherDescriptionLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val weatherDescription: LiveData<String> = Transformations.map(_weatherDescriptionLiveData) {
        it
    }

    private val _sunnyLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    private val _cloudyLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    private val _latitude: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private val _longitude: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private val _timeZoneLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val timeZone: LiveData<String> = Transformations.map(_timeZoneLiveData) {
        it
    }

    private val _dailyLiveData: MutableLiveData<List<DailyData?>?> by lazy {
        MutableLiveData<List<DailyData?>?>()
    }

    val daily: LiveData<List<DailyData?>?> = Transformations.map(_dailyLiveData) {
        it
    }

    private var _weatherIcon: MutableLiveData<ForecastIcon> = MutableLiveData()

    val weatherIcon: LiveData<ForecastIcon> = Transformations.map(_weatherIcon) {
        it
    }

    init {
        _temperatureLiveData.value = "12"
        _weatherDescriptionLiveData.value = "Good Weather"
        _sunnyLiveData.value = true
        _cloudyLiveData.value = true
        _longitude.value = "-"
        _latitude.value = "-"
        _timeZoneLiveData.value = "-"
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

    @MainThread
    private fun updateDaily(forecast: Forecast?) {
        _dailyLiveData.value = forecast?.daily?.data
    }

    @MainThread
    private fun updateCurrently(forecast: Forecast?) {
        val currently = forecast?.currently
        _weatherIcon.value = currently?.icon?.type
        _weatherDescriptionLiveData.value = currently?.summary?.text
        _timeZoneLiveData.value = forecast?.timezone?.replace("_", " ")
        _temperatureLiveData.value = forecast?.currently?.temperature?.text
    }

    suspend fun setLocation(location: Location?) {
        if (location != null) {
            val lat = location.latitude.toString()
            val long = location.longitude.toString()
            getForecast(lat, long)
        }
    }
}
