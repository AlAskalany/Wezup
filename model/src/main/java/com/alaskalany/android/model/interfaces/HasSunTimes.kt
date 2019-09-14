package com.alaskalany.android.model.interfaces

import com.alaskalany.android.model.types.Time

interface HasSunTimes {
    val sunriseTime: Time
    val sunsetTime: Time
}