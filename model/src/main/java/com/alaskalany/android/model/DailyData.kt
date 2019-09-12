package com.alaskalany.android.model

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToLong

data class DailyData(
    override val time: Double? = 0.0,
    override val summary: String? = "",
    override val icon: String? = "",
    override val sunriseTime: Double? = 0.0,
    override val sunsetTime: Double? = 0.0,
    override val moonPhase: Double? = 0.0,
    override val precipIntensity: Double? = 0.0,
    override val precipIntensityMax: Double? = 0.0,
    override val precipIntensityMaxTime: Double? = 0.0,
    override val precipProbability: Double? = 0.0,
    override val precipType: String? = "",
    override val temperatureHigh: Double? = 0.0,
    override val temperatureHighTime: Double? = 0.0,
    override val temperatureLow: Double? = 0.0,
    override val temperatureLowTime: Double? = 0.0,
    override val apparentTemperatureHigh: Double? = 0.0,
    override val apparentTemperatureHighTime: Double? = 0.0,
    override val apparentTemperatureLow: Double? = 0.0,
    override val apparentTemperatureLowTime: Double? = 0.0,
    override val dewPoint: Double? = 0.0,
    override val humidity: Double? = 0.0,
    override val pressure: Double? = 0.0,
    override val windSpeed: Double? = 0.0,
    override val windGust: Double? = 0.0,
    override val windGustTime: Double? = 0.0,
    override val windBearing: Double? = 0.0,
    override val cloudCover: Double? = 0.0,
    override val uvIndex: Double? = 0.0,
    override val uvIndexTime: Double? = 0.0,
    override val visibility: Double? = 0.0,
    override val ozone: Double? = 0.0,
    override val temperatureMin: Double? = 0.0,
    override val temperatureMinTime: Double? = 0.0,
    override val temperatureMax: Double? = 0.0,
    override val temperatureMaxTime: Double? = 0.0,
    override val apparentTemperatureMin: Double? = 0.0,
    override val apparentTemperatureMinTime: Double? = 0.0,
    override val apparentTemperatureMax: Double? = 0.0,
    override val apparentTemperatureMaxTime: Double? = 0.0
) : IDailyData {

    fun getDayName(): String? {
        val asd = Date().also {
            it.time = time?.roundToLong()?.times(1000) ?: 0
        }
        val outFormat = SimpleDateFormat("EEEE")
        return outFormat.format(asd)
    }
}