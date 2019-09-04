package com.alaskalany.android.wezup.ui.main

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

    init {
        _temperatureLiveData.value = "12"
        _weatherDescriptionLiveData.value = "Good Weather"
        _sunnyLiveData.value = true
        _cloudyLiveData.value = true
    }
}
