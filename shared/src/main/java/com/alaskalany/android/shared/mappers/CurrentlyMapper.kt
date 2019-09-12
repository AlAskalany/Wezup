package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.Currently
import com.alaskalany.android.shared.dto.DataPoint

class CurrentlyMapper :
    DataMapper<DataPoint, Currently> {
    override fun map(input: DataPoint?): Currently? {
        return if (input != null) {
            Currently(
                input.time,
                input.summary,
                input.icon,
                input.nearestStormDistance,
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
                input.ozone
            )
        } else {
            null
        }
    }
}