package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.Visibility
import com.alaskalany.android.shared.NonNullDataMapper

object VisibilityMapper :
    NonNullDataMapper<Double, Visibility> {

    override val defaultIfNullValue: Visibility
        get() = Visibility()

    override fun map(input: Double?): Visibility {
        return if (input != null) {
            Visibility(input)
        } else {
            defaultIfNullValue
        }
    }
}