package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.Time

object TimeMapper : NonNullDataMapper<Double, Time> {
    override val defaultIfNullValue: Time
        get() = Time()

    override fun map(input: Double?): Time {
        return if (input != null) {
            Time(input)
        } else {
            defaultIfNullValue
        }
    }
}

