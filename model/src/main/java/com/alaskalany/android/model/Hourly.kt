package com.alaskalany.android.model

data class Hourly(
    val summary: String? = "",
    val icon: String? = "",
    val `data`: List<HourlyData?>? = listOf()
)