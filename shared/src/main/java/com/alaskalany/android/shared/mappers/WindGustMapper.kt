package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.WindGust

object WindGustMapper :
    NonNullDataMapper<Double, WindGust> {

    override val defaultIfNullValue: WindGust
        get() = WindGust()

    override fun map(input: Double?): WindGust {
        return if (input != null) {
            WindGust(input)
        } else {
            defaultIfNullValue
        }
    }
}