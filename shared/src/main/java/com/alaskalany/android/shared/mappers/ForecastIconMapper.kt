package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.types.ForecastIconType
import com.alaskalany.android.model.enums.ForecastIcon
import com.alaskalany.android.shared.DataMapper

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