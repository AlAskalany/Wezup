package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.WindSpeed

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