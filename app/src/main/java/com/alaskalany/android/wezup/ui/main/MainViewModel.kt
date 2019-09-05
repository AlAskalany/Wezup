package com.alaskalany.android.wezup.ui.main

import android.location.Location
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alaskalany.android.model.ICurrently
import com.alaskalany.android.shared.WeatherRepository

class MainViewModel : ViewModel() {

    private val weatherRepository: WeatherRepository = WeatherRepository()

    private val _temperatureLiveData: MutableLiveData<String> = MutableLiveData()

    val temperature: LiveData<String>
        get() = _temperatureLiveData

    private val _weatherDescriptionLiveData: MutableLiveData<String> = MutableLiveData()

    val weatherDescription: LiveData<String>
        get() = _weatherDescriptionLiveData

    private val _sunnyLiveData: MutableLiveData<Boolean> = MutableLiveData()

    val sunny: LiveData<Boolean>
        get() = _sunnyLiveData

    private val _cloudyLiveData: MutableLiveData<Boolean> = MutableLiveData()

    val cloudy: LiveData<Boolean>
        get() = _cloudyLiveData

    private val _latitude: MutableLiveData<String> = MutableLiveData()

    val latitude: LiveData<String>
        get() = _latitude

    private val _longitude: MutableLiveData<String> = MutableLiveData()

    val longitude: LiveData<String>
        get() = _longitude

    private val _timeZoneLiveData: MutableLiveData<String> = MutableLiveData()

    val timeZone: LiveData<String>
        get() = _timeZoneLiveData

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

        val currently = forecast?.currently as ICurrently?
        _weatherDescriptionLiveData.value = currently?.summary
        _timeZoneLiveData.value = forecast?.timezone
        _temperatureLiveData.value = (forecast?.currently as ICurrently?)?.temperature?.toString()
    }

    suspend fun setLocation(location: Location?) {
        if (location != null) {
            val lat = location.latitude.toString()
            val long = location.longitude.toString()
            getForecast(lat, long)
        }
    }
}
