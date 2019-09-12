package com.alaskalany.android.model.data

data class Forecast @JvmOverloads constructor(
    val latitude: Double? = 0.0,
    val longitude: Double? = 0.0,
    val timezone: String? = "",
    val currently: Currently? = Currently(),
    val hourly: Hourly? = Hourly(),
    val daily: Daily? = Daily(),
    val alerts: Alerts = Alerts(),
    val flags: Flags? = Flags()
) : Data<Nothing>(null)