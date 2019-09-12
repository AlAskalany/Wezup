package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.DewPoint

object DewPointMapper :
    NonNullDataMapper<Double, DewPoint> {

    override val defaultIfNullValue: DewPoint
        get() = DewPoint()

    override fun map(input: Double?): DewPoint {
        return if (input != null) {
            DewPoint(input)
        } else {
            defaultIfNullValue
        }
    }
}