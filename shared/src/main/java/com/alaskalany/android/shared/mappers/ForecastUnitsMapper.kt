package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.types.ForecastUnitsType
import com.alaskalany.android.model.enums.ForecastUnits
import com.alaskalany.android.shared.DataMapper

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