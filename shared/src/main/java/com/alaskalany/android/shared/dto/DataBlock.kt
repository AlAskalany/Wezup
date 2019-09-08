package com.alaskalany.android.shared.dto

import com.alaskalany.android.model.IDaily
import com.alaskalany.android.model.IHourly
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
    override val summary: String? = null,
    /**
     * A machine-readable text summary of this [DataBlock]. (May take on the same values as the
     * icon property of [DataPoint]s.)
     *
     * (optional)
     */
    @field:Json(name = "icon")
    override val icon: String? = null,
    /**
     * An array of [DataPoint], ordered by time, which together describe the weather conditions at
     * the requested location over time.
     *
     * (required)
     */
    @field:Json(name = "data")
    override val `data`: List<DataPoint?>? = null
): IDaily, IHourly