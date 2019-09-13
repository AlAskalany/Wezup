package com.alaskalany.android.model.types

import com.alaskalany.android.model.Data
import com.alaskalany.android.model.enums.ForecastIcon

data class ForecastIconType(override val value: ForecastIcon = ForecastIcon.UNKOWN) :
    Data<ForecastIcon>(value) {

    val type
        get() = value
}