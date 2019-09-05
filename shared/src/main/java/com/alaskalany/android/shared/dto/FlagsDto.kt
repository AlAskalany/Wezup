package com.alaskalany.android.shared.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlagsDto(
    @field:Json(name = "sources")
    val sources: List<String?>? = listOf(),
    @field:Json(name = "meteoalarm-license")
    val meteoalarmLicense: String? = "",
    @field:Json(name = "nearest-station")
    val nearestStation: Double? = 0.0,
    @field:Json(name = "units")
    val units: String? = ""
)