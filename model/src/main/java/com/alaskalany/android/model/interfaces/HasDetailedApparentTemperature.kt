package com.alaskalany.android.model.interfaces

import com.alaskalany.android.model.types.Temperature

interface HasDetailedApparentTemperature {
    val apparentTemperatureHigh: Temperature?
    val apparentTemperatureHighTime: Temperature?
    val apparentTemperatureLow: Temperature?
    val apparentTemperatureLowTime: Temperature?
    val apparentTemperatureMin: Temperature?
    val apparentTemperatureMinTime: Temperature?
    val apparentTemperatureMax: Temperature?
    val apparentTemperatureMaxTime: Temperature?
}