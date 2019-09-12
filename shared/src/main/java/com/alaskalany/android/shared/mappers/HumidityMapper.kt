package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.Humidity

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