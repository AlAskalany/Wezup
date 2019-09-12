package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.Data

interface NonNullDataMapper<I, O : Data<*>> : DataMapper<I, O> {
    val defaultIfNullValue: O
}