package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.Flags
import com.alaskalany.android.shared.dto.FlagsDto

class FlagsMapper :
    DataMapper<FlagsDto, Flags> {

    override fun map(input: FlagsDto?): Flags? {
        return if (input != null) {
            Flags(
                input.sources,
                input.meteoalarmLicense,
                input.nearestStation,
                input.units
            )
        } else {
            null
        }
    }
}