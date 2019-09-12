package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.HourlyData
import com.alaskalany.android.shared.DataMapper
import com.alaskalany.android.shared.dto.DataPoint

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
                apparentTemperature = TemperatureMapper.map(input.apparentTemperature),
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