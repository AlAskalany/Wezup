package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.types.CloudCover
import com.alaskalany.android.shared.NonNullDataMapper

object CloudCoverMapper :
    NonNullDataMapper<Double, CloudCover> {

    override val defaultIfNullValue: CloudCover
        get() = CloudCover()

    override fun map(input: Double?): CloudCover {
        return if (input != null) {
            CloudCover(input)
        } else {
            defaultIfNullValue
        }
    }
}