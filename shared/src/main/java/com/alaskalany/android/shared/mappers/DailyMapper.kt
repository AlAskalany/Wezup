package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.DailyData
import com.alaskalany.android.shared.DataMapper
import com.alaskalany.android.shared.dto.DataPoint

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
                precipIntensity = PrecipIntensityMapper.map(input.precipIntensity),
                precipIntensityMax = PrecipIntensityMapper.map(input.precipIntensityMax),
                precipIntensityMaxTime = TimeMapper.map(input.precipIntensityMaxTime),
                precipProbability = PrecipProbabilityMapper.map(input.precipProbability),
                precipType = PrecipTypeMapper.map(input.precipType),
                temperatureHigh = TemperatureMapper.map(input.temperatureHigh),
                temperatureHighTime = TemperatureMapper.map(input.temperatureHighTime),
                temperatureLow = TemperatureMapper.map(input.temperatureLow),
                temperatureLowTime = TemperatureMapper.map(input.temperatureLowTime),
                apparentTemperatureHigh = TemperatureMapper.map(input.apparentTemperatureHigh),
                apparentTemperatureHighTime = TemperatureMapper.map(input.apparentTemperatureHighTime),
                apparentTemperatureLow = TemperatureMapper.map(input.apparentTemperatureLow),
                apparentTemperatureLowTime = TemperatureMapper.map(input.apparentTemperatureLowTime),
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
                temperatureMinTime = TemperatureMapper.map(input.temperatureMinTime),
                temperatureMax = TemperatureMapper.map(input.temperatureMax),
                temperatureMaxTime = TemperatureMapper.map(input.temperatureMaxTime),
                apparentTemperatureMin = TemperatureMapper.map(input.apparentTemperatureMin),
                apparentTemperatureMinTime = TemperatureMapper.map(input.apparentTemperatureMinTime),
                apparentTemperatureMax = TemperatureMapper.map(input.apparentTemperatureMax),
                apparentTemperatureMaxTime = TemperatureMapper.map(input.apparentTemperatureMaxTime)
            )
        } else {
            null
        }
    }
}