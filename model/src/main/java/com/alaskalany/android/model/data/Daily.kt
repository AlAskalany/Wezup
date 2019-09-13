package com.alaskalany.android.model.data

import com.alaskalany.android.model.Data
import com.alaskalany.android.model.HasIcon
import com.alaskalany.android.model.HasSummary
import com.alaskalany.android.model.data.period.DailyData
import com.alaskalany.android.model.types.ForecastIconType
import com.alaskalany.android.model.types.Summary

data class Daily @JvmOverloads constructor(
    override val summary: Summary = Summary(),
    override val icon: ForecastIconType = ForecastIconType(),
    val `data`: List<DailyData?>? = listOf()
) : Data<Nothing>(null), HasSummary, HasIcon