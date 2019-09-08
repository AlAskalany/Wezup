package com.alaskalany.android.model

interface IDaily {
    val summary: String?
    val icon: String?
    val `data`: List<IDailyData?>?
}