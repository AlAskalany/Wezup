package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.Pressure

object PressureMapper :
    NonNullDataMapper<Double, Pressure> {

    override val defaultIfNullValue: Pressure
        get() = Pressure()

    override fun map(input: Double?): Pressure {
        return if (input != null) {
            Pressure(input)
        } else {
            defaultIfNullValue
        }
    }
}