package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.Data

interface DataMapper<in I, out O : Data<*>> {

    fun map(input: I?): O?
}