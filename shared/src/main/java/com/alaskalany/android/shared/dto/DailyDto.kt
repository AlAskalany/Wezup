package com.alaskalany.android.shared.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DailyDto(
    @field:Json(name = "summary")
    val summary: String? = null,
    @field:Json(name = "icon")
    val icon: String? = null,
    @field:Json(name = "data")
    val `data`: List<DailyDataDto?>? = null
)