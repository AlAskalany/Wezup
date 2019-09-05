package com.alaskalany.android.shared.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HourlyDataDto(
    @field:Json(name = "time")
    val time: Double? = 0.0,
    @field:Json(name = "summary")
    val summary: String? = "",
    @field:Json(name = "icon")
    val icon: String? = "",
    @field:Json(name = "precipIntensity")
    val precipIntensity: Double? = 0.0,
    @field:Json(name = "precipProbability")
    val precipProbability: Double? = 0.0,
    @field:Json(name = "temperature")
    val temperature: Double? = 0.0,
    @field:Json(name = "apparentTemperature")
    val apparentTemperature: Double? = 0.0,
    @field:Json(name = "dewPoint")
    val dewPoint: Double? = 0.0,
    @field:Json(name = "humidity")
    val humidity: Double? = 0.0,
    @field:Json(name = "pressure")
    val pressure: Double? = 0.0,
    @field:Json(name = "windSpeed")
    val windSpeed: Double? = 0.0,
    @field:Json(name = "windGust")
    val windGust: Double? = 0.0,
    @field:Json(name = "windBearing")
    val windBearing: Double? = 0.0,
    @field:Json(name = "cloudCover")
    val cloudCover: Double? = 0.0,
    @field:Json(name = "uvIndex")
    val uvIndex: Double? = 0.0,
    @field:Json(name = "visibility")
    val visibility: Double? = 0.0,
    @field:Json(name = "ozone")
    val ozone: Double? = 0.0,
    @field:Json(name = "precipType")
    val precipType: String? = ""
)