package com.alaskalany.android.shared.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlertDto(
    @field:Json(name = "title")
    val title: String? = null,
    @field:Json(name = "regions")
    val regions: List<String?>? = null,
    @field:Json(name = "severity")
    val severity: String? = null,
    @field:Json(name = "time")
    val time: Double? = null,
    @field:Json(name = "expires")
    val expires: Double? = null,
    @field:Json(name = "")
    val description: String? = null,
    @field:Json(name = "uri")
    val uri: String? = null
)