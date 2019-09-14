package com.alaskalany.android.shared.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataBlock @JvmOverloads constructor(
    /**
     * A human-readable summary of this [DataBlock].
     *
     * (optional)
     */
    @field:Json(name = "summary")
    val summary: String? = null,
    /**
     * A machine-readable text summary of this [DataBlock]. (May take on the same values as the
     * icon property of [DataPoint]s.)
     *
     * (optional)
     */
    @field:Json(name = "icon")
    val icon: String? = null,
    /**
     * An array of [DataPoint], ordered by time, which together describe the weather conditions at
     * the requested location over time.
     *
     * (required)
     */
    @field:Json(name = "data")
    val `data`: List<DataPoint?>? = null
)