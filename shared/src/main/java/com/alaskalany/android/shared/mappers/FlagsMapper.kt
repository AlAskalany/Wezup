package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.Flags
import com.alaskalany.android.shared.DataMapper
import com.alaskalany.android.shared.dto.FlagsDto

object FlagsMapper :
    DataMapper<FlagsDto, Flags> {

    override fun map(input: FlagsDto?): Flags? {
        return if (input != null) {
            Flags(
                sources = input.sources,
                meteoalarmLicense = input.meteoalarmLicense,
                nearestStation = input.nearestStation,
                units = ForecastUnitsMapper.map(input.units)
            )
        } else {
            null
        }
    }
}