package com.alaskalany.android.shared

import com.alaskalany.android.model.Data

interface ListDataMapper<I, O : Data<*>> : DataMapper<I, O> {
    val defaultIfNullValue: List<O>
        get() = emptyList()
}