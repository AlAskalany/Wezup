package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.WindSpeed
import com.alaskalany.android.shared.NonNullDataMapper

object WindSpeedMapper :
    NonNullDataMapper<Double, WindSpeed> {

    override val defaultIfNullValue: WindSpeed
        get() = WindSpeed()

    override fun map(input: Double?): WindSpeed {
        return if (input != null) {
            WindSpeed(input)
        } else {
            defaultIfNullValue
        }
    }
}