package com.alaskalany.android.model.data

import com.alaskalany.android.model.enums.ForecastIcon

data class Daily @JvmOverloads constructor(
    override val summary: Summary = Summary(),
    val icon: ForecastIconType = ForecastIconType(ForecastIcon.UNKOWN),
    val `data`: List<DailyData?>? = listOf()
) : Data<Nothing>(null), HasSummary