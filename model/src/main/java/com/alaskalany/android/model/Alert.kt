package com.alaskalany.android.model

data class Alert(
    val title: String? = "",
    val regions: List<String?>? = listOf(),
    val severity: String? = "",
    val time: Double? = 0.0,
    val expires: Double? = 0.0,
    val description: String? = "description",
    val uri: String? = ""
)