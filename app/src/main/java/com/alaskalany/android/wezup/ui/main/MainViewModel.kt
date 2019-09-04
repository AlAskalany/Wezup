package com.alaskalany.android.wezup.ui.main

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
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
}
