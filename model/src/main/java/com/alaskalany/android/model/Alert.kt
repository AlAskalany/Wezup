package com.alaskalany.android.model

data class Alert(
    override val title: String? = "",
    override val regions: List<String?>? = listOf(),
    override val severity: String? = "",
    override val time: Double? = 0.0,
    override val expires: Double? = 0.0,
    override val description: String? = "description",
    override val uri: String? = ""
) : IAlert