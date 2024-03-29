package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.types.Title
import com.alaskalany.android.shared.NonNullDataMapper

object TitleMapper : NonNullDataMapper<String, Title> {

    override val defaultIfNullValue: Title
        get() = Title()

    override fun map(input: String?): Title? {
        return if (input != null) {
            Title(input)
        } else {
            defaultIfNullValue
        }
    }
}