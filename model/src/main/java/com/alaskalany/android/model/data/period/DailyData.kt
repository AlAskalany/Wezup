package com.alaskalany.android.model.data.period

import com.alaskalany.android.model.Data
import com.alaskalany.android.model.interfaces.*
import com.alaskalany.android.model.types.*
import java.text.SimpleDateFormat
import java.util.*

data class DailyData @JvmOverloads constructor(
    override val time: Time = Time(),
    override val summary: Summary = Summary(),
    override val icon: ForecastIconType = ForecastIconType(),
    override val sunriseTime: Time = Time(),
    override val sunsetTime: Time = Time(),
    override val moonPhase: MoonPhase = MoonPhase(),
    override val precipIntensity: PrecipIntensity = PrecipIntensity(),
    override val precipIntensityMax: PrecipIntensity = PrecipIntensity(),
    override val precipIntensityMaxTime: Time = Time(),
    override val precipProbability: PrecipProbability = PrecipProbability(),
    override val precipType: PrecipType = PrecipType(),
    override val temperatureHigh: Temperature? = Temperature(),
    override val temperatureHighTime: Temperature? = Temperature(),
    override val temperatureLow: Temperature? = Temperature(),
    override val temperatureLowTime: Temperature? = Temperature(),
    override val apparentTemperatureHigh: Temperature? = Temperature(),
    override val apparentTemperatureHighTime: Temperature? = Temperature(),
    override val apparentTemperatureLow: Temperature? = Temperature(),
    override val apparentTemperatureLowTime: Temperature? = Temperature(),
    override val dewPoint: DewPoint = DewPoint(),
    override val humidity: Humidity = Humidity(),
    override val pressure: Pressure = Pressure(),
    override val windSpeed: WindSpeed = WindSpeed(),
    override val windGust: WindGust = WindGust(),
    override val windGustTime: Time = Time(),
    override val windBearing: WindBearing = WindBearing(),
    override val cloudCover: CloudCover = CloudCover(),
    override val uvIndex: UvIndex = UvIndex(),
    val uvIndexTime: Time = Time(),
    override val visibility: Visibility = Visibility(),
    override val ozone: Ozone = Ozone(),
    override val temperatureMin: Temperature? = Temperature(),
    override val temperatureMinTime: Temperature? = Temperature(),
    override val temperatureMax: Temperature? = Temperature(),
    override val temperatureMaxTime: Temperature? = Temperature(),
    override val apparentTemperatureMin: Temperature? = Temperature(),
    override val apparentTemperatureMinTime: Temperature? = Temperature(),
    override val apparentTemperatureMax: Temperature? = Temperature(),
    override val apparentTemperatureMaxTime: Temperature? = Temperature()
) : Data<Nothing>(null),
    PeriodData,
    HasSunTimes,
    HasMoonPhase,
    HasDetailedTemperature,
    HasDetailedApparentTemperature,
    HasPrecipType,
    HasDetailedWindGust, HasDetailedPrecipIntensity {

    val dayName: String?
        get() {
            val asd = Date().also {
                it.time = time.longValue
            }
            val outFormat = SimpleDateFormat("EEEE")
            return outFormat.format(asd)
        }
}