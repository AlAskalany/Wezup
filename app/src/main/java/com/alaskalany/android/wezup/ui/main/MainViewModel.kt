package com.alaskalany.android.wezup.ui.main

import android.location.Location
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.alaskalany.android.model.IDailyData
import com.alaskalany.android.model.IForecast
import com.alaskalany.android.shared.WeatherRepository
import kotlin.math.roundToInt

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

    private val _dailyLiveData: MutableLiveData<List<IDailyData?>?> by lazy {
        MutableLiveData<List<IDailyData?>?>()
    }

    val daily: LiveData<List<IDailyData?>?> = Transformations.map(_dailyLiveData) {
        it
    }

    private var _weatherIcon: MutableLiveData<String> = MutableLiveData()

    val weatherIcon: LiveData<String> = Transformations.map(_weatherIcon) {
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
    private fun updateDaily(forecast: IForecast?) {
        _dailyLiveData.value = forecast?.daily?.data
    }

    @MainThread
    private fun updateCurrently(forecast: IForecast?) {
        val currently = forecast?.currently
        _weatherIcon.value = currently?.icon
        _weatherDescriptionLiveData.value = currently?.summary
        _timeZoneLiveData.value = forecast?.timezone?.replace("_", " ")
        _temperatureLiveData.value = forecast?.currently?.temperature?.roundToInt()?.toString()
    }

    suspend fun setLocation(location: Location?) {
        if (location != null) {
            val lat = location.latitude.toString()
            val long = location.longitude.toString()
            getForecast(lat, long)
        }
    }
}
