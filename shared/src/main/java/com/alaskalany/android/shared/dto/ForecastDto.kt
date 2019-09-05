package com.alaskalany.android.shared.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForecastDto(
    @field:Json(name = "latitude")
    val latitude: Double? = 0.0,
    @field:Json(name = "longitude")
    val longitude: Double? = 0.0,
    @field:Json(name = "timezone")
    val timezone: String? = "",
    @field:Json(name = "currently")
    val currently: CurrentlyDto? = CurrentlyDto(),
    @field:Json(name = "hourly")
    val hourly: HourlyDto? = HourlyDto(),
    @field:Json(name = "daily")
    val daily: DailyDto? = DailyDto(),
    @field:Json(name = "alerts")
    val alerts: List<AlertDto?>? = listOf(),
    @field:Json(name = "flags")
    val flags: Flags? = Flags(),
    @field:Json(name = "offset")
    val offset: Double? = 0.0
)