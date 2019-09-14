package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.types.Pressure
import com.alaskalany.android.shared.NonNullDataMapper

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