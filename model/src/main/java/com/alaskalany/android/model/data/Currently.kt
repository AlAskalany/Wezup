package com.alaskalany.android.model.data

import com.alaskalany.android.model.enums.ForecastIcon

data class Currently @JvmOverloads constructor(
    val time: Time = Time(),
    override val summary: Summary = Summary(),
    val icon: ForecastIconType = ForecastIconType(ForecastIcon.UNKOWN),
    val nearestStormDistance: NearestStormDistance = NearestStormDistance(),
    val precipIntensity: PrecipIntensity = PrecipIntensity(),
    val precipProbability: PrecipProbability = PrecipProbability(),
    val temperature: Temperature? = Temperature(),
    val apparentTemperature: Temperature? = Temperature(),
    val dewPoint: DewPoint = DewPoint(),
    val humidity: Humidity = Humidity(),
    val pressure: Pressure = Pressure(),
    val windSpeed: WindSpeed = WindSpeed(),
    val windGust: WindGust = WindGust(),
    val windBearing: WindBearing = WindBearing(),
    val cloudCover: CloudCover = CloudCover(),
    val uvIndex: UvIndex = UvIndex(),
    val visibility: Visibility = Visibility(),
    val ozone: Ozone = Ozone()
) : Data<Nothing>(null), HasSummary