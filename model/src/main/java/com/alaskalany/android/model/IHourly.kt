package com.alaskalany.android.model

interface IHourly {
    val summary: String?
    val icon: String?
    val `data`: List<IHourlyData?>?
}