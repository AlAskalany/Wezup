package com.alaskalany.android.model.data

data class Alert @JvmOverloads constructor(
    override val title: Title? = Title(),
    val regions: List<String?>? = listOf(),
    val severity: String? = "",
    val time: Time = Time(),
    val expires: Double? = 0.0,
    val description: Description = Description(),
    val uri: String? = ""
) : Data<Nothing>(null), HasTitle