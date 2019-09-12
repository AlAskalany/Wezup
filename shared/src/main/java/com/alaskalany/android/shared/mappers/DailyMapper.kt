package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.DailyData
import com.alaskalany.android.shared.dto.DataPoint

class DailyMapper : DataMapper<DataPoint, DailyData> {
    override fun map(input: DataPoint?): DailyData? {
        return if (input != null) {
            DailyData(
                input.time,
                input.summary,
                input.icon,
                input.sunriseTime,
                input.sunsetTime,
                input.moonPhase,
                input.precipIntensity,
                input.precipIntensityMax,
                input.precipIntensityMaxTime,
                input.precipProbability,
                input.precipType,
                input.temperatureHigh,
                input.temperatureHighTime,
                input.temperatureLow,
                input.temperatureLowTime,
                input.apparentTemperatureHigh,
                input.apparentTemperatureHighTime,
                input.apparentTemperatureLow,
                input.apparentTemperatureLowTime,
                input.dewPoint,
                input.humidity,
                input.pressure,
                input.windSpeed,
                input.windGust,
                input.windGustTime,
                input.windBearing,
                input.cloudCover,
                input.uvIndex,
                input.uvIndexTime,
                input.visibility,
                input.ozone,
                input.temperatureMin,
                input.temperatureMinTime,
                input.temperatureMax,
                input.temperatureMaxTime,
                input.apparentTemperatureMin,
                input.apparentTemperatureMinTime,
                input.apparentTemperatureMax,
                input.apparentTemperatureMaxTime
            )
        } else {
            null
        }
    }
}