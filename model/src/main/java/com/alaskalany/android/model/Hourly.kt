package com.alaskalany.android.model

data class Hourly(
    override val summary: String? = "",
    override val icon: String? = "",
    override val `data`: List<HourlyData?>? = listOf()
) : IHourly