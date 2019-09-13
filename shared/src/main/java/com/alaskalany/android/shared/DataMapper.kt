package com.alaskalany.android.shared

import com.alaskalany.android.model.Data

interface DataMapper<in I, out O : Data<*>> {

    fun map(input: I?): O?
}