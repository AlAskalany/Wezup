package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.PrecipType
import com.alaskalany.android.shared.NonNullDataMapper

object PrecipTypeMapper : NonNullDataMapper<String, PrecipType> {
    override val defaultIfNullValue: PrecipType
        get() = PrecipType()

    override fun map(input: String?): PrecipType {
        return if (input != null) {
            PrecipType(input)
        } else {
            defaultIfNullValue
        }
    }
}
