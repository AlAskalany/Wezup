package com.alaskalany.android.shared.dto

import com.alaskalany.android.model.IFlags
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlagsDto @JvmOverloads constructor(
    /**
     *
     */
    @field:Json(name = "darksky-unavailable")
    val darkSkyUnavailable: Any? = null,
    /**
     * This property contains an array of IDs for each data source utilized in servicing
     * this request.
     *
     * (optional)
     *
     */
    @field:Json(name = "sources")
    override val sources: List<String?>? = null,
    /**
     * This property contains an array of IDs for each data source utilized in servicing
     * this request.
     *
     * (required)
     *
     */
    @field:Json(name = "meteoalarm-license")
    override val meteoalarmLicense: String? = null,
    /**
     * The distance to the nearest weather station that contributed data to this response.
     * Note, however, that many other stations may have also been used; this value is primarily
     * for debugging purposes. This property's value is in miles (if US units are selected) or
     * kilometers (if SI units are selected).
     *
     * (required)
     *
     */
    @field:Json(name = "nearest-station")
    override val nearestStation: Double? = null,
    /**
     * Indicates the units which were used for the data in this request.
     *
     * (required)
     *
     */
    @field:Json(name = "units")
    override val units: String? = null
): IFlags