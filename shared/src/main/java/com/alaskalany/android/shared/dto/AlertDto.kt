package com.alaskalany.android.shared.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlertDto(
    @field:Json(name = "title")
    val title: String? = "",
    @field:Json(name = "regions")
    val regions: List<String?>? = listOf(),
    @field:Json(name = "severity")
    val severity: String? = "",
    @field:Json(name = "time")
    val time: Int? = 0,
    @field:Json(name = "expires")
    val expires: Double? = 0.0,
    @field:Json(name = "")
    val description: String? = "description",
    @field:Json(name = "uri")
    val uri: String? = ""
)