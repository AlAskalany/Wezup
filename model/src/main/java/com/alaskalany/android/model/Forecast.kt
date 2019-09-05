package com.alaskalany.android.model

data class Forecast(
    val latitude: Double? = 0.0,
    val longitude: Double? = 0.0,
    val timezone: String? = "",
    val currently: Currently? = Currently(),
    val hourly: Hourly? = Hourly(),
    val daily: Daily? = Daily(),
    val alerts: List<Alert?>? = listOf(),
    val flags: Flags? = Flags(),
    val offset: Double? = 0.0
)