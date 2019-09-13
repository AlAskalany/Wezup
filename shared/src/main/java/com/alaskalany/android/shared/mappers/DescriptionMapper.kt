package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.types.Description
import com.alaskalany.android.shared.DataMapper

object DescriptionMapper : DataMapper<String, Description> {
    override fun map(input: String?): Description {
        return if (input != null) {
            Description(input)
        } else {
            Description()
        }
    }
}