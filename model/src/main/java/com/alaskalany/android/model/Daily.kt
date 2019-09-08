package com.alaskalany.android.model

data class Daily(
    override val summary: String? = "",
    override val icon: String? = "",
    override val `data`: List<DailyData?>? = listOf()
) : IDaily