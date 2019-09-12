package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.Description

object DescriptionMapper : DataMapper<String, Description> {
    override fun map(input: String?): Description {
        return if (input != null) {
            Description(input)
        } else {
            Description()
        }
    }
}