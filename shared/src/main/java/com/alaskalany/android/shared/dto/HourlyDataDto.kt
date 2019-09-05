package com.alaskalany.android.shared.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HourlyDataDto(
    @field:Json(name = "time")
    val time: Double? = null,
    @field:Json(name = "summary")
    val summary: String? = null,
    @field:Json(name = "icon")
    val icon: String? = null,
    @field:Json(name = "precipIntensity")
    val precipIntensity: Double? = null,
    @field:Json(name = "precipProbability")
    val precipProbability: Double? = null,
    @field:Json(name = "temperature")
    val temperature: Double? = null,
    @field:Json(name = "apparentTemperature")
    val apparentTemperature: Double? = null,
    @field:Json(name = "dewPoint")
    val dewPoint: Double? = null,
    @field:Json(name = "humidity")
    val humidity: Double? = null,
    @field:Json(name = "pressure")
    val pressure: Double? = null,
    @field:Json(name = "windSpeed")
    val windSpeed: Double? = null,
    @field:Json(name = "windGust")
    val windGust: Double? = null,
    @field:Json(name = "windBearing")
    val windBearing: Double? = null,
    @field:Json(name = "cloudCover")
    val cloudCover: Double? = null,
    @field:Json(name = "uvIndex")
    val uvIndex: Double? = null,
    @field:Json(name = "visibility")
    val visibility: Double? = null,
    @field:Json(name = "ozone")
    val ozone: Double? = null,
    @field:Json(name = "precipType")
    val precipType: String? = null
)