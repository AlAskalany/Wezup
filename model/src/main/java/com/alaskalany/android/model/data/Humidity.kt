package com.alaskalany.android.model.data

data class Humidity @JvmOverloads constructor(override val value: Double = 0.0) :
    Data<Double>(value)