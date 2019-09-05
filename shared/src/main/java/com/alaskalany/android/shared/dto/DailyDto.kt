package com.alaskalany.android.shared.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DailyDto(
    @field:Json(name = "summary")
    val summary: String? = "",
    @field:Json(name = "icon")
    val icon: String? = "",
    @field:Json(name = "data")
    val `data`: List<DailyDataDto?>? = listOf()
)