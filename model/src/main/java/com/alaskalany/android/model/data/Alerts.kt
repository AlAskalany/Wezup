package com.alaskalany.android.model.data

import com.alaskalany.android.model.Data

data class Alerts @JvmOverloads constructor(override val value: List<Alert?> = emptyList()) :
    Data<List<Alert?>>(value)