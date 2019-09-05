package com.alaskalany.android.model.enums

@Suppress("unused")
enum class ForecastSiUnits(val value: String) {
    /**
     * Any summaries containing temperature or snow accumulation units will have their values in degrees Celsius or in centimeters (respectively).
     */
    SUMMARY("summary"),
    /**
     * Kilometers.
     */
    NEAREST_STORM_DISTANCE("nearestStormDistance"),
    /**
     * Millimeters per hour.
     */
    PRECIP_INTENSITY("precipIntensity"),
    /**
     * Millimeters per hour.
     */
    PRECIP_INTENSITY_MAX("precipIntensityMax"),
    /**
     * Centimeters.
     */
    PRECIP_ACCUMULATION("precipAccumulation"),
    /**
     * Degrees Celsius.
     */
    TEMPERATURE("temperature"),
    /**
     * Degrees Celsius.
     */
    TEMPERATURE_MIN("temperatureMin"),
    /**
     * Degrees Celsius.
     */
    TEMPERATURE_MAX("temperatureMax"),
    /**
     * Degrees Celsius.
     */
    APPARENT_TEMPERATURE("apparentTemperature"),
    /**
     * Degrees Celsius.
     */
    DEW_POINT("dewPoint"),
    /**
     * Meters per second.
     */
    WIND_SPEED("windSpeed"),
    /**
     * Meters per second.
     */
    WIND_GUST("windGust"),
    /**
     * Hectopascals.
     */
    PRESSURE("pressure"),
    /**
     * Kilometers.
     */
    VISIBILITY("visibility"),
}