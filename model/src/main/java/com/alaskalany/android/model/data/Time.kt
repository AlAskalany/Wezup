package com.alaskalany.android.model.data

import kotlin.math.roundToLong

data class Time(override val value: Double = 0.0) : Data<Double>(value) {
    val longValue: Long
        get() = value.roundToLong().times(1000)
}