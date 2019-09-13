package com.alaskalany.android.model.data

import com.alaskalany.android.model.Data
import com.alaskalany.android.model.types.ForecastUnitsType

data class Flags @JvmOverloads constructor(
    val sources: List<String?>? = listOf(),
    val meteoalarmLicense: String? = "",
    val nearestStation: Double? = 0.0,
    val units: ForecastUnitsType = ForecastUnitsType()
) : Data<Nothing>(null)