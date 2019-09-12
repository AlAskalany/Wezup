package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.UvIndex

object UvIndexMapper :
    NonNullDataMapper<Double, UvIndex> {

    override val defaultIfNullValue: UvIndex
        get() = UvIndex()

    override fun map(input: Double?): UvIndex {
        return if (input != null) {
            UvIndex(input)
        } else {
            defaultIfNullValue
        }
    }
}