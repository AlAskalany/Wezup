package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.*
import com.alaskalany.android.model.enums.ForecastIcon
import com.alaskalany.android.model.enums.ForecastUnits
import com.alaskalany.android.shared.dto.*

object DewPointMapper : NonNullDataMapper<Double, DewPoint> {

    override val defaultIfNullValue: DewPoint
        get() = DewPoint()

    override fun map(input: Double?): DewPoint {
        return if (input != null) {
            DewPoint(input)
        } else {
            defaultIfNullValue
        }
    }
}

interface DataMapper<in I, out O : Data<*>> {

    fun map(input: I?): O?
}

object ForecastMapper : DataMapper<ForecastDto, Forecast> {

    override fun map(input: ForecastDto?): Forecast? {
        return if (input != null) {
            Forecast(
                latitude = input.latitude,
                longitude = input.longitude,
                timezone = input.timezone,
                currently = CurrentlyMapper.map(input.currently),
                hourly = HourlyListMapper.map(input.hourly),
                daily = DailyListMapper.map(input.daily),
                alerts = AltersListMapper.map(input.alerts),
                flags = FlagsMapper.map(input.flags)
            )
        } else {
            null
        }
    }
}

object HumidityMapper : NonNullDataMapper<Double, Humidity> {

    override val defaultIfNullValue: Humidity
        get() = Humidity()

    override fun map(input: Double?): Humidity {
        return if (input != null) {
            Humidity(input)
        } else {
            defaultIfNullValue
        }
    }
}

object WindGustMapper : NonNullDataMapper<Double, WindGust> {

    override val defaultIfNullValue: WindGust
        get() = WindGust()

    override fun map(input: Double?): WindGust {
        return if (input != null) {
            WindGust(input)
        } else {
            defaultIfNullValue
        }
    }
}

object MoonPhaseMapper : DataMapper<Double, MoonPhase> {
    override fun map(input: Double?): MoonPhase {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

object PrecipProbabilityMapper : NonNullDataMapper<Double, PrecipProbability> {

    override val defaultIfNullValue: PrecipProbability
        get() = PrecipProbability()

    override fun map(input: Double?): PrecipProbability {
        return if (input != null) {
            PrecipProbability(input)
        } else {
            defaultIfNullValue
        }
    }
}

object DailyListMapper : DataMapper<DataBlock, Daily> {


    override fun map(input: DataBlock?): Daily? {
        return if (input != null) {
            Daily(summary = SummaryMapper.map(input.summary),
                icon = ForecastIconMapper.map(input.icon),
                data = input.data?.map { dataPoint ->
                    dataPoint?.let {
                        DailyMapper.map(
                            it
                        )
                    }
                })
        } else {
            null
        }
    }
}

object VisibilityMapper : NonNullDataMapper<Double, Visibility> {

    override val defaultIfNullValue: Visibility
        get() = Visibility()

    override fun map(input: Double?): Visibility {
        return if (input != null) {
            Visibility(input)
        } else {
            defaultIfNullValue
        }
    }
}

object TitleMapper : NonNullDataMapper<String, Title> {

    override val defaultIfNullValue: Title
        get() = Title()

    override fun map(input: String?): Title? {
        return if (input != null) {
            Title(input)
        } else {
            defaultIfNullValue
        }
    }
}

object PrecipTypeMapper : NonNullDataMapper<String, PrecipType> {
    override val defaultIfNullValue: PrecipType
        get() = PrecipType()

    override fun map(input: String?): PrecipType {
        return if (input != null) {
            PrecipType(input)
        } else {
            defaultIfNullValue
        }
    }
}

object FlagsMapper : DataMapper<FlagsDto, Flags> {

    override fun map(input: FlagsDto?): Flags? {
        return if (input != null) {
            Flags(
                sources = input.sources,
                meteoalarmLicense = input.meteoalarmLicense,
                nearestStation = input.nearestStation,
                units = ForecastUnitsMapper.map(input.units)
            )
        } else {
            null
        }
    }
}

object ForecastUnitsMapper : DataMapper<String, ForecastUnitsType> {
    override fun map(input: String?): ForecastUnitsType {
        return ForecastUnitsType(
            when (input) {
                ForecastUnits.CA.value -> ForecastUnits.CA
                ForecastUnits.SI.value -> ForecastUnits.SI
                ForecastUnits.UK2.value -> ForecastUnits.UK2
                ForecastUnits.US.value -> ForecastUnits.US
                else -> ForecastUnits.AUTO
            }
        )
    }
}

object WindBearingMapper : NonNullDataMapper<Double, WindBearing> {

    override val defaultIfNullValue: WindBearing
        get() = WindBearing()

    override fun map(input: Double?): WindBearing {
        return if (input != null) {
            WindBearing(input)
        } else {
            defaultIfNullValue
        }
    }
}

object OzoneMapper : NonNullDataMapper<Double, Ozone> {

    override val defaultIfNullValue: Ozone
        get() = Ozone()

    override fun map(input: Double?): Ozone {
        return if (input != null) {
            Ozone(input)
        } else {
            defaultIfNullValue
        }
    }
}

object DescriptionMapper : DataMapper<String, Description> {
    override fun map(input: String?): Description {
        return if (input != null) {
            Description(input)
        } else {
            Description()
        }
    }
}

object WindSpeedMapper : NonNullDataMapper<Double, WindSpeed> {

    override val defaultIfNullValue: WindSpeed
        get() = WindSpeed()

    override fun map(input: Double?): WindSpeed {
        return if (input != null) {
            WindSpeed(input)
        } else {
            defaultIfNullValue
        }
    }
}

object UvIndexMapper : NonNullDataMapper<Double, UvIndex> {

    override val defaultIfNullValue: UvIndex
        get() = UvIndex()

    override fun map(input: Double?): UvIndex {
        return if (input != null) {
            UvIndex(input)
        } else {
            defaultIfNullValue
        }
    }
}

object TimeMapper : NonNullDataMapper<Double, Time> {
    override val defaultIfNullValue: Time
        get() = Time()

    override fun map(input: Double?): Time {
        return if (input != null) {
            Time(input)
        } else {
            defaultIfNullValue
        }
    }
}

object DailyMapper : DataMapper<DataPoint, DailyData> {

    override fun map(input: DataPoint?): DailyData? {
        return if (input != null) {
            DailyData(
                time = TimeMapper.map(input.time),
                summary = SummaryMapper.map(input.summary),
                icon = ForecastIconMapper.map(input.icon),
                sunriseTime = TimeMapper.map(input.sunriseTime),
                sunsetTime = TimeMapper.map(input.sunsetTime),
                moonPhase = MoonPhaseMapper.map(input.moonPhase),
                precipIntensity = PrecipIntensityMapper.map(
                    input.precipIntensity
                ),
                precipIntensityMax = PrecipIntensityMapper.map(
                    input.precipIntensityMax
                ),
                precipIntensityMaxTime = TimeMapper.map(input.precipIntensityMaxTime),
                precipProbability = PrecipProbabilityMapper.map(
                    input.precipProbability
                ),
                precipType = PrecipTypeMapper.map(input.precipType),
                temperatureHigh = TemperatureMapper.map(input.temperatureHigh),
                temperatureHighTime = TemperatureMapper.map(
                    input.temperatureHighTime
                ),
                temperatureLow = TemperatureMapper.map(input.temperatureLow),
                temperatureLowTime = TemperatureMapper.map(
                    input.temperatureLowTime
                ),
                apparentTemperatureHigh = TemperatureMapper.map(
                    input.apparentTemperatureHigh
                ),
                apparentTemperatureHighTime = TemperatureMapper.map(
                    input.apparentTemperatureHighTime
                ),
                apparentTemperatureLow = TemperatureMapper.map(
                    input.apparentTemperatureLow
                ),
                apparentTemperatureLowTime = TemperatureMapper.map(
                    input.apparentTemperatureLowTime
                ),
                dewPoint = DewPointMapper.map(input.dewPoint),
                humidity = HumidityMapper.map(input.humidity),
                pressure = PressureMapper.map(input.pressure),
                windSpeed = WindSpeedMapper.map(input.windSpeed),
                windGust = WindGustMapper.map(input.windGust),
                windGustTime = TimeMapper.map(input.windGustTime),
                windBearing = WindBearingMapper.map(input.windBearing),
                cloudCover = CloudCoverMapper.map(input.cloudCover),
                uvIndex = UvIndexMapper.map(input.uvIndex),
                uvIndexTime = TimeMapper.map(input.uvIndexTime),
                visibility = VisibilityMapper.map(input.visibility),
                ozone = OzoneMapper.map(input.ozone),
                temperatureMin = TemperatureMapper.map(input.temperatureMin),
                temperatureMinTime = TemperatureMapper.map(
                    input.temperatureMinTime
                ),
                temperatureMax = TemperatureMapper.map(input.temperatureMax),
                temperatureMaxTime = TemperatureMapper.map(
                    input.temperatureMaxTime
                ),
                apparentTemperatureMin = TemperatureMapper.map(
                    input.apparentTemperatureMin
                ),
                apparentTemperatureMinTime = TemperatureMapper.map(
                    input.apparentTemperatureMinTime
                ),
                apparentTemperatureMax = TemperatureMapper.map(
                    input.apparentTemperatureMax
                ),
                apparentTemperatureMaxTime = TemperatureMapper.map(
                    input.apparentTemperatureMaxTime
                )
            )
        } else {
            null
        }
    }
}

object SummaryMapper : NonNullDataMapper<String, Summary> {

    override val defaultIfNullValue: Summary
        get() = Summary()

    override fun map(input: String?): Summary {
        return if (input != null) {
            Summary(input)
        } else {
            defaultIfNullValue
        }
    }
}

object AltersListMapper : DataMapper<List<AlertDto?>, Alerts> {

    override fun map(input: List<AlertDto?>?): Alerts {
        return input?.filterNotNull()?.map { AlertMapper.map(it) }?.let {
            Alerts(
                it
            )
        } ?: Alerts()
    }
}

object PressureMapper : NonNullDataMapper<Double, Pressure> {

    override val defaultIfNullValue: Pressure
        get() = Pressure()

    override fun map(input: Double?): Pressure {
        return if (input != null) {
            Pressure(input)
        } else {
            defaultIfNullValue
        }
    }
}

object PrecipIntensityMapper : NonNullDataMapper<Double, PrecipIntensity> {

    override val defaultIfNullValue: PrecipIntensity
        get() = PrecipIntensity()

    override fun map(input: Double?): PrecipIntensity {
        return if (input != null) {
            PrecipIntensity(input)
        } else {
            defaultIfNullValue
        }
    }
}

object TemperatureMapper : NonNullDataMapper<Double, Temperature> {

    override val defaultIfNullValue: Temperature
        get() = Temperature()

    override fun map(input: Double?): Temperature {
        return if (input != null) {
            Temperature(input)
        } else {
            defaultIfNullValue
        }
    }
}

object HourlyMapper : DataMapper<DataPoint, HourlyData> {

    override fun map(input: DataPoint?): HourlyData? {
        return if (input != null) {
            HourlyData(
                time = TimeMapper.map(input.time),
                summary = SummaryMapper.map(input.summary),
                icon = ForecastIconMapper.map(input.icon),
                precipIntensity = input.precipIntensity,
                precipProbability = input.precipProbability,
                temperature = input.temperature,
                apparentTemperature = TemperatureMapper.map(
                    input.apparentTemperature
                ),
                dewPoint = DewPointMapper.map(input.dewPoint),
                humidity = HumidityMapper.map(input.humidity),
                pressure = PressureMapper.map(input.pressure),
                windSpeed = WindSpeedMapper.map(input.windSpeed),
                windGust = WindGustMapper.map(input.windGust),
                windBearing = WindBearingMapper.map(input.windBearing),
                cloudCover = CloudCoverMapper.map(input.cloudCover),
                uvIndex = UvIndexMapper.map(input.uvIndex),
                visibility = VisibilityMapper.map(input.visibility),
                ozone = OzoneMapper.map(input.ozone),
                precipType = PrecipTypeMapper.map(input.precipType)
            )
        } else {
            null
        }
    }
}

object NearestStormDistanceMapper : NonNullDataMapper<Double, NearestStormDistance> {

    override val defaultIfNullValue: NearestStormDistance
        get() = NearestStormDistance()

    override fun map(input: Double?): NearestStormDistance {
        return if (input != null) {
            NearestStormDistance(input)
        } else {
            defaultIfNullValue
        }
    }
}

object CurrentlyMapper : DataMapper<DataPoint, Currently> {

    override fun map(input: DataPoint?): Currently? {
        return if (input != null) {
            Currently(
                time = TimeMapper.map(input.time),
                summary = SummaryMapper.map(input.summary),
                icon = ForecastIconMapper.map(input.icon),
                nearestStormDistance = NearestStormDistanceMapper.map(
                    input.nearestStormDistance
                ),
                precipIntensity = PrecipIntensityMapper.map(
                    input.precipIntensity
                ),
                precipProbability = PrecipProbabilityMapper.map(
                    input.precipProbability
                ),
                temperature = TemperatureMapper.map(input.temperature),
                apparentTemperature = TemperatureMapper.map(
                    input.apparentTemperature
                ),
                dewPoint = DewPointMapper.map(input.dewPoint),
                humidity = HumidityMapper.map(input.humidity),
                pressure = PressureMapper.map(input.pressure),
                windSpeed = WindSpeedMapper.map(input.windSpeed),
                windGust = WindGustMapper.map(input.windGust),
                windBearing = WindBearingMapper.map(input.windBearing),
                cloudCover = CloudCoverMapper.map(input.cloudCover),
                uvIndex = UvIndexMapper.map(input.uvIndex),
                visibility = VisibilityMapper.map(input.visibility),
                ozone = OzoneMapper.map(input.ozone)
            )
        } else {
            null
        }
    }
}

object CloudCoverMapper : NonNullDataMapper<Double, CloudCover> {

    override val defaultIfNullValue: CloudCover
        get() = CloudCover()

    override fun map(input: Double?): CloudCover {
        return if (input != null) {
            CloudCover(input)
        } else {
            defaultIfNullValue
        }
    }
}

object AlertMapper : DataMapper<AlertDto, Alert> {

    override fun map(input: AlertDto?): Alert? {
        return if (input != null) {
            Alert(
                title = TitleMapper.map(input.title),
                regions = input.regions,
                severity = input.severity,
                time = TimeMapper.map(input.time),
                expires = input.expires,
                description = DescriptionMapper.map(input.description),
                uri = input.uri
            )
        } else {
            null
        }
    }
}

object ForecastIconMapper : DataMapper<String, ForecastIconType> {
    override fun map(input: String?): ForecastIconType {
        return ForecastIconType(
            when (input) {
                ForecastIcon.CLEAR_DAY.value -> ForecastIcon.CLEAR_DAY
                ForecastIcon.CLEAR_NIGHT.value -> ForecastIcon.CLEAR_NIGHT
                ForecastIcon.PARTLY_CLOUDY_DAY.value -> ForecastIcon.PARTLY_CLOUDY_DAY
                ForecastIcon.PARTLY_CLOUD_NIGHT.value -> ForecastIcon.PARTLY_CLOUD_NIGHT
                ForecastIcon.CLOUDY.value -> ForecastIcon.CLOUDY
                ForecastIcon.RAIN.value -> ForecastIcon.RAIN
                ForecastIcon.SLEET.value -> ForecastIcon.SLEET
                ForecastIcon.SNOW.value -> ForecastIcon.SNOW
                ForecastIcon.WIND.value -> ForecastIcon.WIND
                ForecastIcon.FOG.value -> ForecastIcon.FOG
                else -> ForecastIcon.UNKOWN
            }
        )
    }
}

object HourlyListMapper : DataMapper<DataBlock, Hourly> {

    override fun map(input: DataBlock?): Hourly? {
        return if (input != null) {
            Hourly(summary = SummaryMapper.map(input.summary),
                icon = ForecastIconMapper.map(input.icon),
                data = input.data?.map { dataPoint ->
                    dataPoint?.let {
                        HourlyMapper.map(
                            it
                        )
                    }
                })
        } else {
            null
        }
    }
}