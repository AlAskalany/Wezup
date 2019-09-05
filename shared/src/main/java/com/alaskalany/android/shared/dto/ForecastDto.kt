package com.alaskalany.android.shared.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForecastDto @JvmOverloads constructor(

    //<editor-fold desc="Required">
    /**
     * required
     * The IANA timezone name for the requested location. This is used for text summaries and
     * for determining when hourly and daily data block objects begin.
     */
    @field:Json(name = "timezone")
    val timezone: String? = null,

    /**
     * required
     * The requested latitude.
     */
    @field:Json(name = "latitude")
    val latitude: Double? = null,

    /**
     *  required
     *  The requested longitude.
     */
    @field:Json(name = "longitude")
    val longitude: Double? = null,
    //</editor-fold>

    //<editor-fold desc="Optional">
    /**
     * optional
     * A data point containing the current weather conditions at the requested location.
     */
    @field:Json(name = "currently")
    val currently: DataPoint? = null,

    /**
     * optional
     * A data block containing the weather conditions hour-by-hour for the next two days.
     */
    @field:Json(name = "hourly")
    val hourly: DataBlock? = null,

    /**
     * optional
     * A data block containing the weather conditions day-by-day for the next week.
     */
    @field:Json(name = "daily")
    val daily: DataBlock? = null,

    /**
     * optional
     * An alerts array, which, if present, contains any severe weather alerts pertinent to the
     * requested location.
     */
    @field:Json(name = "alerts")
    val alerts: List<AlertDto?>? = null,

    /**
     * optional
    A flags object containing miscellaneous metadata about the request.
     */
    @field:Json(name = "flags")
    val flags: FlagsDto? = null
    //</editor-fold>
)