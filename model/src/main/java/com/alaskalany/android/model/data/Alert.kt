package com.alaskalany.android.model.data

import com.alaskalany.android.model.Data
import com.alaskalany.android.model.HasTime
import com.alaskalany.android.model.HasTitle
import com.alaskalany.android.model.types.Description
import com.alaskalany.android.model.types.Time
import com.alaskalany.android.model.types.Title

data class Alert @JvmOverloads constructor(
    override val title: Title? = Title(),
    val regions: List<String?>? = listOf(),
    val severity: String? = "",
    override val time: Time = Time(),
    val expires: Double? = 0.0,
    val description: Description = Description(),
    val uri: String? = ""
) : Data<Nothing>(null), HasTitle, HasTime