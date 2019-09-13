package com.alaskalany.android.model.types

import com.alaskalany.android.model.Data

data class PrecipProbability(override val value: Double = 0.0) : Data<Double>(value) {

    companion object {
        @JvmStatic
        fun empty(): PrecipProbability {
            return PrecipProbability()
        }
    }
}