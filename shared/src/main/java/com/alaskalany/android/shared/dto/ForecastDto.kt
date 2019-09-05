package com.alaskalany.android.shared.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForecastDto(
    // required
    @field:Json(name = "latitude")
    val latitude: Double? = null,
    // required
    @field:Json(name = "longitude")
    val longitude: Double? = null,
    @field:Json(name = "timezone")
    // required
    val timezone: String? = null,
    // optional
    @field:Json(name = "currently")
    val currently: CurrentlyDto? = null,
    // optional
    @field:Json(name = "hourly")
    val hourly: HourlyDto? = null,
    @field:Json(name = "daily")
    val daily: DailyDto? = null,
    @field:Json(name = "alerts")
    val alerts: List<AlertDto?>? = null,
    @field:Json(name = "flags")
    val flags: FlagsDto? = null,
    @field:Json(name = "offset")
    val offset: Double? = null
)