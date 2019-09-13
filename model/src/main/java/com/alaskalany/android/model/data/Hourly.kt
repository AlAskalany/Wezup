package com.alaskalany.android.model.data

import com.alaskalany.android.model.Data
import com.alaskalany.android.model.HasIcon
import com.alaskalany.android.model.HasSummary
import com.alaskalany.android.model.interfaces.HasHourlyDataList
import com.alaskalany.android.model.types.ForecastIconType
import com.alaskalany.android.model.types.Summary

data class Hourly @JvmOverloads constructor(
    override val summary: Summary = Summary(),
    override val icon: ForecastIconType = ForecastIconType(),
    override val `data`: HourlyDataList = HourlyDataList()
) : Data<Nothing>(null), HasSummary, HasIcon,
    HasHourlyDataList