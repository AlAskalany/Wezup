package com.alaskalany.android.model

data class Alert(
    val title: String = "",
    val regions: List<String> = listOf(),
    val severity: String = "",
    val time: Int = 0,
    val expires: Int = 0,
    val description: String = "",
    val uri: String = ""
)