package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.Time
import com.alaskalany.android.shared.NonNullDataMapper

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

