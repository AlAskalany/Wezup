package com.alaskalany.android.model.enums

/**
 * The severity of the weather alert.
 */
@Suppress("unused")
enum class AlertSeverity(val value: String) {
    /**
     * An individual should be aware of potentially severe weather.
     */
    ADVISORY("advisory"),
    /**
     * An individual should prepare for potentially severe weather.
     */
    WATCH("watch"),
    /**
     * An individual should take immediate action to protect themselves and others from potentially severe weather.
     */
    WARNING("warning")
}