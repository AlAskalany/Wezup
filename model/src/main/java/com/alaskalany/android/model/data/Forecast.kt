package com.alaskalany.android.model.data

import com.alaskalany.android.model.Data
import com.alaskalany.android.model.data.period.CurrentlyData
import com.alaskalany.android.model.interfaces.HasLocation
import com.alaskalany.android.model.interfaces.HasTimeZone

data class Forecast @JvmOverloads constructor(
    override val latitude: Double? = 0.0,
    override val longitude: Double? = 0.0,
    override val timezone: String? = "",
    val currently: CurrentlyData? = CurrentlyData(),
    val hourly: Hourly? = Hourly(),
    val daily: Daily? = Daily(),
    val alerts: Alerts = Alerts(),
    val flags: Flags? = Flags()
) : Data<Nothing>(null),
    HasLocation,
    HasTimeZone