package com.alaskalany.android.model.data

data class Alerts(override val value: List<Alert?> = emptyList()) : Data<List<Alert?>>(value)