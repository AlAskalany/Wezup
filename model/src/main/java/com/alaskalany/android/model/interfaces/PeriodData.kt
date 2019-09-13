package com.alaskalany.android.model.interfaces

import com.alaskalany.android.model.HasIcon
import com.alaskalany.android.model.HasSummary
import com.alaskalany.android.model.HasTime

interface PeriodData : HasSummary, HasTime, HasIcon,
    HasDewPoint,
    HasPrecipIntensity,
    HasPrecipProbability,
    HasWindSpeed,
    HasWindGust,
    HasVisibility,
    HasHumidity,
    HasOzone,
    HasUvIndex,
    HasCloudCover,
    HasWindBearing,
    HasPressure
