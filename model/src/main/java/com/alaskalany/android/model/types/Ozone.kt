package com.alaskalany.android.model.types

import com.alaskalany.android.model.Data

data class Ozone(override val value: Double = 0.0) : Data<Double>(value)