package com.alaskalany.android.model.interfaces

import com.alaskalany.android.model.types.Temperature

interface HasDetailedTemperature {
    val temperatureMin: Temperature?
    val temperatureMinTime: Temperature?
    val temperatureMax: Temperature?
    val temperatureMaxTime: Temperature?
    val temperatureHigh: Temperature?
    val temperatureHighTime: Temperature?
    val temperatureLow: Temperature?
    val temperatureLowTime: Temperature?
}