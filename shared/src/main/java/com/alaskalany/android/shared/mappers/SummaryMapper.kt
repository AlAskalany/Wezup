package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.Summary

object SummaryMapper : NonNullDataMapper<String, Summary> {

    override val defaultIfNullValue: Summary
        get() = Summary()

    override fun map(input: String?): Summary {
        return if (input != null) {
            Summary(input)
        } else {
            defaultIfNullValue
        }
    }
}