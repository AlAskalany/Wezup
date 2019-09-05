package com.alaskalany.android.model

data class DailyData(
    val time: Double? = 0.0,
    val summary: String? = "",
    val icon: String? = "",
    val sunriseTime: Double? = 0.0,
    val sunsetTime: Double? = 0.0,
    val moonPhase: Double? = 0.0,
    val precipIntensity: Double? = 0.0,
    val precipIntensityMax: Double? = 0.0,
    val precipIntensityMaxTime: Double? = 0.0,
    val precipProbability: Double? = 0.0,
    val precipType: String? = "",
    val temperatureHigh: Double? = 0.0,
    val temperatureHighTime: Double? = 0.0,
    val temperatureLow: Double? = 0.0,
    val temperatureLowTime: Double? = 0.0,
    val apparentTemperatureHigh: Double? = 0.0,
    val apparentTemperatureHighTime: Double? = 0.0,
    val apparentTemperatureLow: Double? = 0.0,
    val apparentTemperatureLowTime: Double? = 0.0,
    val dewPoint: Double? = 0.0,
    val humidity: Double? = 0.0,
    val pressure: Double? = 0.0,
    val windSpeed: Double? = 0.0,
    val windGust: Double? = 0.0,
    val windGustTime: Double? = 0.0,
    val windBearing: Double? = 0.0,
    val cloudCover: Double? = 0.0,
    val uvIndex: Double? = 0.0,
    val uvIndexTime: Double? = 0.0,
    val visibility: Double? = 0.0,
    val ozone: Double? = 0.0,
    val temperatureMin: Double? = 0.0,
    val temperatureMinTime: Double? = 0.0,
    val temperatureMax: Double? = 0.0,
    val temperatureMaxTime: Double? = 0.0,
    val apparentTemperatureMin: Double? = 0.0,
    val apparentTemperatureMinTime: Double? = 0.0,
    val apparentTemperatureMax: Double? = 0.0,
    val apparentTemperatureMaxTime: Double? = 0.0
)