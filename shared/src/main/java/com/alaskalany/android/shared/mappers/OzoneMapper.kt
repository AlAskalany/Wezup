package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.Ozone

object OzoneMapper :
    NonNullDataMapper<Double, Ozone> {

    override val defaultIfNullValue: Ozone
        get() = Ozone()

    override fun map(input: Double?): Ozone {
        return if (input != null) {
            Ozone(input)
        } else {
            defaultIfNullValue
        }
    }
}