package com.alaskalany.android.model

data class HourlyData(
    val time: Int = 0,
    val summary: String = "",
    val icon: String = "",
    val precipIntensity: Int = 0,
    val precipProbability: Int = 0,
    val temperature: Double = 0.0,
    val apparentTemperature: Double = 0.0,
    val dewPoint: Double = 0.0,
    val humidity: Double = 0.0,
    val pressure: Double = 0.0,
    val windSpeed: Double = 0.0,
    val windGust: Double = 0.0,
    val windBearing: Int = 0,
    val cloudCover: Double = 0.0,
    val uvIndex: Int = 0,
    val visibility: Int = 0,
    val ozone: Double = 0.0,
    val precipType: String = ""
)