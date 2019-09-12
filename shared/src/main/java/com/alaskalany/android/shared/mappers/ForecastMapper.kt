package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.Forecast
import com.alaskalany.android.shared.dto.ForecastDto

class ForecastMapper :
    DataMapper<ForecastDto, Forecast> {

    private val currentlyMapper = CurrentlyMapper()
    private val hourlyListMapper = HourlyListMapper()
    private val dailyListMapper = DailyListMapper()
    private val alertListMapper = AltersListMapper()
    private val flagsMapper = FlagsMapper()

    override fun map(input: ForecastDto?): Forecast? {
        return if (input != null) {
            Forecast(
                input.latitude,
                input.longitude,
                input.timezone,
                currentlyMapper.map(input.currently),
                hourlyListMapper.map(input.hourly),
                dailyListMapper.map(input.daily),
                alertListMapper.map(input.alerts),
                flagsMapper.map(input.flags)
            )
        } else {
            null
        }
    }
}