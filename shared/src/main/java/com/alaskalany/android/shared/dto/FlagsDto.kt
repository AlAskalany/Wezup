package com.alaskalany.android.shared.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlagsDto(
    @field:Json(name = "sources")
    val sources: List<String?>? = null,
    @field:Json(name = "meteoalarm-license")
    val meteoalarmLicense: String? = null,
    @field:Json(name = "nearest-station")
    val nearestStation: Double? = null,
    @field:Json(name = "units")
    val units: String? = null
)