package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.HourlyData
import com.alaskalany.android.shared.dto.DataPoint

class HourlyMapper : DataMapper<DataPoint, HourlyData> {

    override fun map(input: DataPoint?): HourlyData? {
        return if (input != null) {
            HourlyData(
                input.time,
                input.summary,
                input.icon,
                input.precipIntensity,
                input.precipProbability,
                input.temperature,
                input.apparentTemperature,
                input.dewPoint,
                input.humidity,
                input.pressure,
                input.windSpeed,
                input.windGust,
                input.windBearing,
                input.cloudCover,
                input.uvIndex,
                input.visibility,
                input.ozone,
                input.precipType
            )
        } else {
            null
        }
    }
}