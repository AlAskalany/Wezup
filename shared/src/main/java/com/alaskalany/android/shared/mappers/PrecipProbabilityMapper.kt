package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.PrecipProbability
import com.alaskalany.android.shared.NonNullDataMapper

object PrecipProbabilityMapper :
    NonNullDataMapper<Double, PrecipProbability> {

    override val defaultIfNullValue: PrecipProbability
        get() = PrecipProbability()

    override fun map(input: Double?): PrecipProbability {
        return if (input != null) {
            PrecipProbability(input)
        } else {
            defaultIfNullValue
        }
    }
}