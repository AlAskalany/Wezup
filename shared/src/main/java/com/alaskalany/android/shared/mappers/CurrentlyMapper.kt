package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.Currently
import com.alaskalany.android.shared.DataMapper
import com.alaskalany.android.shared.dto.DataPoint

object CurrentlyMapper :
    DataMapper<DataPoint, Currently> {

    override fun map(input: DataPoint?): Currently? {
        return if (input != null) {
            Currently(
                time = TimeMapper.map(input.time),
                summary = SummaryMapper.map(input.summary),
                icon = ForecastIconMapper.map(input.icon),
                nearestStormDistance = NearestStormDistanceMapper.map(input.nearestStormDistance),
                precipIntensity = PrecipIntensityMapper.map(input.precipIntensity),
                precipProbability = PrecipProbabilityMapper.map(input.precipProbability),
                temperature = TemperatureMapper.map(input.temperature),
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
                ozone = OzoneMapper.map(input.ozone)
            )
        } else {
            null
        }
    }
}