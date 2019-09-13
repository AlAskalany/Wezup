package com.alaskalany.android.model.interfaces

import com.alaskalany.android.model.types.PrecipIntensity
import com.alaskalany.android.model.types.PrecipType
import com.alaskalany.android.model.types.Time

interface HasPrecipIntensity {
    val precipIntensity: PrecipIntensity
}

interface HasDetailedWindGust: HasWindGust {
    val windGustTime: Time
}

interface HasDetailedPrecipIntensity : HasPrecipIntensity {
    val precipIntensityMax: PrecipIntensity
    val precipIntensityMaxTime: Time
}

interface HasPrecipType {
    val precipType: PrecipType
}