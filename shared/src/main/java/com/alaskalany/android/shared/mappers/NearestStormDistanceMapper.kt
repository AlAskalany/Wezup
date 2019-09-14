package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.types.NearestStormDistance
import com.alaskalany.android.shared.NonNullDataMapper

object NearestStormDistanceMapper :
    NonNullDataMapper<Double, NearestStormDistance> {

    override val defaultIfNullValue: NearestStormDistance
        get() = NearestStormDistance()

    override fun map(input: Double?): NearestStormDistance {
        return if (input != null) {
            NearestStormDistance(input)
        } else {
            defaultIfNullValue
        }
    }
}