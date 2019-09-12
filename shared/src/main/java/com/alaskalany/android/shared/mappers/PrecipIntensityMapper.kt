package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.PrecipIntensity

object PrecipIntensityMapper :
    NonNullDataMapper<Double, PrecipIntensity> {

    override val defaultIfNullValue: PrecipIntensity
        get() = PrecipIntensity()

    override fun map(input: Double?): PrecipIntensity {
        return if (input != null) {
            PrecipIntensity(input)
        } else {
            defaultIfNullValue
        }
    }
}