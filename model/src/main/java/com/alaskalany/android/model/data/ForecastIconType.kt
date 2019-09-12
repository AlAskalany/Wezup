package com.alaskalany.android.model.data

import com.alaskalany.android.model.enums.ForecastIcon

data class ForecastIconType(override val value: ForecastIcon) : Data<ForecastIcon>(value) {
    val type
        get() = value
}