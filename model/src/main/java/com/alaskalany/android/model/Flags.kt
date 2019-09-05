package com.alaskalany.android.model

data class Flags(
    val sources: List<String?>? = listOf(),
    val meteoalarmLicense: String? = "",
    val nearestStation: Double? = 0.0,
    val units: String? = ""
)