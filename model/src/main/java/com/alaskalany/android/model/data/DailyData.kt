package com.alaskalany.android.model.data

import com.alaskalany.android.model.enums.ForecastIcon
import java.text.SimpleDateFormat
import java.util.*

data class DailyData @JvmOverloads constructor(
    val time: Time = Time(),
    override val summary: Summary = Summary(),
    val icon: ForecastIconType = ForecastIconType(ForecastIcon.UNKOWN),
    val sunriseTime: Time = Time(),
    val sunsetTime: Time = Time(),
    val moonPhase: MoonPhase = MoonPhase(),
    val precipIntensity: PrecipIntensity = PrecipIntensity(),
    val precipIntensityMax: PrecipIntensity = PrecipIntensity(),
    val precipIntensityMaxTime: Time = Time(),
    val precipProbability: PrecipProbability = PrecipProbability(),
    val precipType: PrecipType = PrecipType(),
    val temperatureHigh: Temperature? = Temperature(),
    val temperatureHighTime: Temperature? = Temperature(),
    val temperatureLow: Temperature? = Temperature(),
    val temperatureLowTime: Temperature? = Temperature(),
    val apparentTemperatureHigh: Temperature? = Temperature(),
    val apparentTemperatureHighTime: Temperature? = Temperature(),
    val apparentTemperatureLow: Temperature? = Temperature(),
    val apparentTemperatureLowTime: Temperature? = Temperature(),
    val dewPoint: DewPoint = DewPoint(),
    val humidity: Humidity = Humidity(),
    val pressure: Pressure = Pressure(),
    val windSpeed: WindSpeed = WindSpeed(),
    val windGust: WindGust = WindGust(),
    val windGustTime: Time = Time(),
    val windBearing: WindBearing = WindBearing(),
    val cloudCover: CloudCover = CloudCover(),
    val uvIndex: UvIndex = UvIndex(),
    val uvIndexTime: Time = Time(),
    val visibility: Visibility = Visibility(),
    val ozone: Ozone = Ozone(),
    val temperatureMin: Temperature? = Temperature(),
    val temperatureMinTime: Temperature? = Temperature(),
    val temperatureMax: Temperature? = Temperature(),
    val temperatureMaxTime: Temperature? = Temperature(),
    val apparentTemperatureMin: Temperature? = Temperature(),
    val apparentTemperatureMinTime: Temperature? = Temperature(),
    val apparentTemperatureMax: Temperature? = Temperature(),
    val apparentTemperatureMaxTime: Temperature? = Temperature()
) : Data<Nothing>(null), HasSummary {

    val dayName: String?
        get() {
            val asd = Date().also {
                it.time = time.longValue
            }
            val outFormat = SimpleDateFormat("EEEE")
            return outFormat.format(asd)
        }
}