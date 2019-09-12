package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.Forecast
import com.alaskalany.android.shared.DataMapper
import com.alaskalany.android.shared.dto.ForecastDto

object ForecastMapper :
    DataMapper<ForecastDto, Forecast> {

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