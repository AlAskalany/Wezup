package com.alaskalany.android.shared

import com.alaskalany.android.model.Data

interface NonNullDataMapper<I, O : Data<*>> : DataMapper<I, O> {
    val defaultIfNullValue: O
}