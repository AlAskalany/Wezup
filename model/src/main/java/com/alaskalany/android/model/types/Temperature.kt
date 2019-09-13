package com.alaskalany.android.model.types

import com.alaskalany.android.model.Data
import kotlin.math.roundToInt

data class Temperature(override val value: Double = 0.0) : Data<Double?>(value) {
    val text: String
        get() = value.roundToInt().toString()
}