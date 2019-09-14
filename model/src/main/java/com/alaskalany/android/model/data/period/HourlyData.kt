package com.alaskalany.android.model.data.period

import com.alaskalany.android.model.Data
import com.alaskalany.android.model.interfaces.HasApparentTemperature
import com.alaskalany.android.model.interfaces.HasNearestStormDistance
import com.alaskalany.android.model.interfaces.HasTemperature
import com.alaskalany.android.model.interfaces.PeriodData
import com.alaskalany.android.model.types.*

data class HourlyData @JvmOverloads constructor(
    override val time: Time = Time(),
    override val summary: Summary = Summary(),
    override val icon: ForecastIconType = ForecastIconType(),
    override val precipIntensity: PrecipIntensity = PrecipIntensity(),
    override val precipProbability: PrecipProbability = PrecipProbability(),
    override val temperature: Temperature = Temperature(),
    override val apparentTemperature: Temperature = Temperature(),
    override val dewPoint: DewPoint = DewPoint(),
    override val humidity: Humidity = Humidity(),
    override val pressure: Pressure = Pressure(),
    override val windSpeed: WindSpeed = WindSpeed(),
    override val windGust: WindGust = WindGust(),
    override val windBearing: WindBearing = WindBearing(),
    override val cloudCover: CloudCover = CloudCover(),
    override val uvIndex: UvIndex = UvIndex(),
    override val visibility: Visibility = Visibility(),
    override val ozone: Ozone = Ozone(),
    val precipType: PrecipType = PrecipType()
) : Data<Nothing>(null),
    PeriodData,
    HasApparentTemperature,
    HasTemperature
