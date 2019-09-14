package com.alaskalany.android.model.types

import com.alaskalany.android.model.Data
import com.alaskalany.android.model.enums.ForecastUnits

data class ForecastUnitsType(override val value: ForecastUnits = ForecastUnits.AUTO) :
    Data<ForecastUnits>(value)
