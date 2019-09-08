package com.alaskalany.android.shared.dto

import com.alaskalany.android.model.IForecast
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
    override val timezone: String? = null,

    /**
     * required
     * The requested latitude.
     */
    @field:Json(name = "latitude")
    override val latitude: Double? = null,

    /**
     *  required
     *  The requested longitude.
     */
    @field:Json(name = "longitude")
    override val longitude: Double? = null,
    //</editor-fold>

    //<editor-fold desc="Optional">
    /**
     * optional
     * A data point containing the current weather conditions at the requested location.
     */
    @field:Json(name = "currently")
    override val currently: DataPoint? = null,

    /**
     * optional
     * A data block containing the weather conditions hour-by-hour for the next two days.
     */
    @field:Json(name = "hourly")
    override val hourly: DataBlock? = null,

    /**
     * optional
     * A data block containing the weather conditions day-by-day for the next week.
     */
    @field:Json(name = "daily")
    override val daily: DataBlock? = null,

    /**
     * optional
     * An alerts array, which, if present, contains any severe weather alerts pertinent to the
     * requested location.
     */
    @field:Json(name = "alerts")
    override val alerts: List<AlertDto?>? = null,

    /**
     * optional
    A flags object containing miscellaneous metadata about the request.
     */
    @field:Json(name = "flags")
    override val flags: FlagsDto? = null
    //</editor-fold>
): IForecast