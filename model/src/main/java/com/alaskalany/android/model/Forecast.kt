package com.alaskalany.android.model

data class Forecast(
    override val latitude: Double? = 0.0,
    override val longitude: Double? = 0.0,
    override val timezone: String? = "",
    override val currently: Currently? = Currently(),
    override val hourly: Hourly? = Hourly(),
    override val daily: Daily? = Daily(),
    override val alerts: List<Alert?>? = listOf(),
    override val flags: Flags? = Flags()
) : IForecast