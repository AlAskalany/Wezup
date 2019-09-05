package com.alaskalany.android.model

data class Daily(
    val summary: String? = "",
    val icon: String? = "",
    val `data`: List<DailyData?>? = listOf()
)