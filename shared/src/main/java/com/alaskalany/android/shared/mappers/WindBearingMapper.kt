package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.types.WindBearing
import com.alaskalany.android.shared.NonNullDataMapper

object WindBearingMapper :
    NonNullDataMapper<Double, WindBearing> {

    override val defaultIfNullValue: WindBearing
        get() = WindBearing()

    override fun map(input: Double?): WindBearing {
        return if (input != null) {
            WindBearing(input)
        } else {
            defaultIfNullValue
        }
    }
}