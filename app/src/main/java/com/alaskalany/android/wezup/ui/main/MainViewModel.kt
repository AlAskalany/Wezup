package com.alaskalany.android.wezup.ui.main

import android.app.Application
import android.app.Service
import android.location.Location
import android.net.ConnectivityManager
import androidx.annotation.MainThread
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.alaskalany.android.model.data.Forecast
import com.alaskalany.android.model.data.period.DailyData
import com.alaskalany.android.model.enums.ForecastIcon
import com.alaskalany.android.shared.WeatherRepository
import com.alaskalany.android.wezup.WezupApplication

class MainViewModel(application: WezupApplication) : AndroidViewModel(application) {

    private val weatherRepository: WeatherRepository = WeatherRepository()

    private val _online: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val online: LiveData<Boolean> = Transformations.map(_online) {
        it
    }

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

    private var latitude: String? = null
    private var longitude: String? = null

    init {
        _temperatureLiveData.value = "12"
        _weatherDescriptionLiveData.value = "Good Weather"
        _sunnyLiveData.value = true
        _cloudyLiveData.value = true
        _longitude.value = "-"
        _latitude.value = "-"
        _timeZoneLiveData.value = "-"
        _online.value = isConnected()
    }

    private fun isConnected(): Boolean {
        val cm =
            getApplication<Application>().getSystemService(Service.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork?.isConnected == true
    }

    private suspend fun getForecast() {
        if (isConnected()) {
            val lat = latitude
            val long = longitude
            if (lat != null && long != null) {
                val forecast = weatherRepository.fetchForecast(
                    "dafc50f09edd941ce1876d78a0a31b77", lat, long
                )

                println(forecast)

                updateCurrently(forecast)
                updateDaily(forecast)
            }
        }
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
            latitude = location.latitude.toString()
            longitude = location.longitude.toString()
            getForecast()
        }
    }

    fun setOnlineState(connected: Boolean) {
        _online.value = connected
    }

    suspend fun refresh() {
        getForecast()
    }
}
