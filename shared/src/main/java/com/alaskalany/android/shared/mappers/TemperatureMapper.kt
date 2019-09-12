package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.Temperature

object TemperatureMapper : NonNullDataMapper<Double, Temperature> {

    override val defaultIfNullValue: Temperature
        get() = Temperature()

    override fun map(input: Double?): Temperature {
        return if (input != null) {
            Temperature(input)
        } else {
            defaultIfNullValue
        }
    }
}