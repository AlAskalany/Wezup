package com.alaskalany.android.model.enums

@Suppress("unused")
enum class ForecastUnits(val value: String) {

    /**
     * automatically select units based on geographic location
     */
    AUTO("auto"),   //
    /**
     * same as si, except that windSpeed and windGust are in kilometers per hour
     */
    CA("ca"),
    /**
     * same as si, except that nearestStormDistance and visibility are in miles, and windSpeed and windGust in miles per hour
     */
    UK2("uk2"),
    /**
     * Imperial units (the default)
     */
    US("us"),
    /**
     * SI units
     */
    SI("si"),
}