package com.alaskalany.android.model

data class HourlyData(
    override val time: Double? = 0.0,
    override val summary: String? = "",
    override val icon: String? = "",
    override val precipIntensity: Double? = 0.0,
    override val precipProbability: Double? = 0.0,
    override val temperature: Double? = 0.0,
    override val apparentTemperature: Double? = 0.0,
    override val dewPoint: Double? = 0.0,
    override val humidity: Double? = 0.0,
    override val pressure: Double? = 0.0,
    override val windSpeed: Double? = 0.0,
    override val windGust: Double? = 0.0,
    override val windBearing: Double? = 0.0,
    override val cloudCover: Double? = 0.0,
    override val uvIndex: Double? = 0.0,
    override val visibility: Double? = 0.0,
    override val ozone: Double? = 0.0,
    override val precipType: String? = ""
) : IHourlyData