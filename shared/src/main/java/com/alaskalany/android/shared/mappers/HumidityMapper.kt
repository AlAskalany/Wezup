package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.types.Humidity
import com.alaskalany.android.shared.NonNullDataMapper

object HumidityMapper :
    NonNullDataMapper<Double, Humidity> {

    override val defaultIfNullValue: Humidity
        get() = Humidity()

    override fun map(input: Double?): Humidity {
        return if (input != null) {
            Humidity(input)
        } else {
            defaultIfNullValue
        }
    }
}