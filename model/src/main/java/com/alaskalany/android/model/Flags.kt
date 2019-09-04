package com.alaskalany.android.model

data class Flags(
    val sources: List<String> = listOf(),
    // meteoalarm-license
    val meteoalarmLicense: String = "",
    // nearest-station
    val nearestStation: Double = 0.0,
    val units: String = ""
)