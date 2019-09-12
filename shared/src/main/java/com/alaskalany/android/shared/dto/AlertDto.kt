package com.alaskalany.android.shared.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlertDto @JvmOverloads constructor(
    /**
     * A brief description of the alert.
     *
     * (required)
     */
    @field:Json(name = "title")
    val title: String? = null,
    /**
     * An array of strings representing the names of the regions covered by this weather alert.
     *
     * (required)
     */
    @field:Json(name = "regions")
    val regions: List<String?>? = null,
    /**
     * The severity of the weather alert. Will take one of the following values: "advisory" (an
     * individual should be aware of potentially severe weather), "watch" (an individual should
     * prepare for potentially severe weather), or "warning" (an individual should take immediate
     * action to protect themselves and others from potentially severe weather).
     *
     * (required)
     */
    @field:Json(name = "severity")
    val severity: String? = null,
    /**
     * The UNIX time at which the alert was issued.
     *
     * (required)
     */
    @field:Json(name = "time")
    val time: Double? = null,
    /**
     * The UNIX time at which the alert will expire.
     *
     * (required)
     */
    @field:Json(name = "expires")
    val expires: Double? = null,
    /**
     * A detailed description of the alert.
     *
     * (required)
     */
    @field:Json(name = "")
    val description: String? = null,
    /**
     * An HTTP(S) URI that one may refer to for detailed information about the alert.
     *
     * (required)
     */
    @field:Json(name = "uri") val uri: String? = null
)