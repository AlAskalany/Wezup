package com.alaskalany.android.model

data class Flags(
    override val sources: List<String?>? = listOf(),
    override val meteoalarmLicense: String? = "",
    override val nearestStation: Double? = 0.0,
    override val units: String? = ""
) : IFlags