package com.alaskalany.android.model.enums

@Suppress("unused")
enum class DataBlock(val value: String) {

    CURRENTLY("currently"),
    MINUTELY("minutely"),
    HOURLY("hourly"),
    DAILY("daily"),
    ALERTS("alerts"),
    FLAGS("flags")
}