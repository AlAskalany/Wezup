package com.alaskalany.android.shared.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataPoint @JvmOverloads constructor(

    //<editor-fold desc="Required">
    /**
     * required
     *
     * The UNIX time at which this data point begins. minutely data point are always aligned to
     * the top of the minute, hourly data point objects to the top of the hour, and daily
     * [DataPoint] objects to midnight of the day, all according to the local time zone.
     */
    @field:Json(name = "time")
    val time: Double? = null,
    //</editor-fold>

    //<editor-fold desc="Optional">
    /**
     * optional
     *
     * A human-readable text summary of this data point. (This property has millions of possible
     * values, so don’t use it for automated purposes: use the icon property, instead!)
     */
    @field:Json(name = "summary")
    val summary: String? = null,

    /**
     *  optional
     *
     *  A machine-readable text summary of this data point, suitable for selecting an icon for
     *  display. If defined, this property will have one of the following values: clear-day,
     *  clear-night, rain, snow, sleet, wind, fog, cloudy, partly-cloudy-day, or
     *  partly-cloudy-night. (Developers should ensure that a sensible default is defined,
     *  as additional values, such as hail, thunderstorm, or tornado, may be defined in
     *  the future.)
     */
    @field:Json(name = "icon")
    val icon: String? = null,

    /**
     * optional
     *
     * The intensity (in inches of liquid water per hour) of precipitation occurring at the given
     * time. This value is conditional on probability (that is, assuming any precipitation occurs
     * at all).
     */
    @field:Json(name = "precipIntensity")
    val precipIntensity: Double? = null,

    /**
     * optional
     *
     * The probability of precipitation occurring, between 0 and 1, inclusive.
     */
    @field:Json(name = "precipProbability")
    val precipProbability: Double? = null,

    /**
     * optional
     *
     * The type of precipitation occurring at the given time. If defined, this property will have
     * one of the following values: "rain", "snow", or "sleet" (which refers to each of freezing
     * rain, ice pellets, and “wintery mix”). (If precipIntensity is zero, then this property will
     * not be defined. Additionally, due to the lack of data in our sources, historical precipType
     * information is usually estimated, rather than observed.)
     */
    @field:Json(name = "precipType")
    val precipType: String? = null,

    /**
     * optional
     *
     * The dew point in degrees Fahrenheit.
     */
    @field:Json(name = "dewPoint")
    val dewPoint: Double? = null,

    /**
     * optional
     *
     * The relative humidity, between 0 and 1, inclusive.
     */
    @field:Json(name = "humidity")
    val humidity: Double? = null,

    /**
     * optional
     *
     * The sea-level air pressure in millibars.
     */
    @field:Json(name = "pressure")
    val pressure: Double? = null,

    /**
     * optional
     *
    The wind speed in miles per hour.
     */
    @field:Json(name = "windSpeed")
    val windSpeed: Double? = null,

    /**
     *  optional
     *
    The wind gust speed in miles per hour.
     */
    @field:Json(name = "windGust")
    val windGust: Double? = null,

    /**
     * optional
     *
    The direction that the wind is coming from in degrees, with true north at 0° and progressing clockwise. (If windSpeed is zero, then this value will not be defined.)
     */
    @field:Json(name = "windBearing")
    val windBearing: Double? = null,

    /**
     * optional
     *
     * The percentage of sky occluded by clouds, between 0 and 1, inclusive.
     */
    @field:Json(name = "cloudCover")
    val cloudCover: Double? = null,

    /**
     * optional
     *
    The UV index.
     */
    @field:Json(name = "uvIndex")
    val uvIndex: Double? = null,

    /**
     * optional
     *
    The average visibility in miles, capped at 10 miles.
     */
    @field:Json(name = "visibility")
    val visibility: Double? = null,

    /**
     * optional
     *
     * The columnar density of total atmospheric ozone at the given time in Dobson units.
     */
    @field:Json(name = "ozone")
    val ozone: Double? = null,
    //</editor-fold>

    //<editor-fold desc="Daily">
    /**
     * optional, only on daily
     *
     * The UNIX time of when the sun will rise during a given day.
     */
    @field:Json(name = "sunriseTime")
    val sunriseTime: Double? = null,

    /**
     *  optional, only on daily
     *
     *  The UNIX time of when the sun will set during a given day.
     */
    @field:Json(name = "sunsetTime")
    val sunsetTime: Double? = null,

    /**
     * optional, only on daily
     *
     * The fractional part of the lunation number during the given day: a value of 0 corresponds
     * to a new moon, 0.25 to a first quarter moon, 0.5 to a full moon, and 0.75 to a last quarter
     * moon. (The ranges in between these represent waxing crescent, waxing gibbous, waning
     * gibbous, and waning crescent moons, respectively.)
     */
    @field:Json(name = "moonPhase")
    val moonPhase: Double? = null,

    /**
     * optional, only on daily
     *
     * The maximum value of precipIntensity during a given day.
     */
    @field:Json(name = "precipIntensityMax")
    val precipIntensityMax: Double? = null,

    /**
     * optional, only on daily
     *
     * The UNIX time of when precipIntensityMax occurs during a given day.
     */
    @field:Json(name = "precipIntensityMaxTime")
    val precipIntensityMaxTime: Double? = null,

    /**
     * optional, only on daily
     *
     * The daytime high temperature.
     */
    @field:Json(name = "temperatureHigh")
    val temperatureHigh: Double? = null,

    /**
     * optional, only on daily
     *
     * The UNIX time representing when the daytime high temperature occurs.
     */
    @field:Json(name = "temperatureHighTime")
    val temperatureHighTime: Double? = null,

    /**
     * optional, only on daily
     *
     * The overnight low temperature.
     */
    @field:Json(name = "temperatureLow")
    val temperatureLow: Double? = null,

    /**
     * optional, only on daily
     *
     * The UNIX time representing when the overnight low temperature occurs.
     */
    @field:Json(name = "temperatureLowTime")
    val temperatureLowTime: Double? = null,

    /**
     * optional, only on daily
     *
    The daytime high apparent temperature.
     */
    @field:Json(name = "apparentTemperatureHigh")
    val apparentTemperatureHigh: Double? = null,

    /**
     * optional, only on daily
     *
    The UNIX time representing when the daytime high apparent temperature occurs.
     */
    @field:Json(name = "apparentTemperatureHighTime")
    val apparentTemperatureHighTime: Double? = null,

    /**
     * optional, only on daily
     *
    The overnight low apparent temperature.
     */
    @field:Json(name = "apparentTemperatureLow")
    val apparentTemperatureLow: Double? = null,

    /**
     * optional, only on daily
     *
    The UNIX time representing when the overnight low apparent temperature occurs.
     */
    @field:Json(name = "apparentTemperatureLowTime")
    val apparentTemperatureLowTime: Double? = null,

    /**
     * optional, only on daily
     *
    The time at which the maximum wind gust speed occurs during the day.
     */
    @field:Json(name = "windGustTime")
    val windGustTime: Double? = null,

    /**
     *  optional, only on daily
     *
    The UNIX time of when the maximum uvIndex occurs during a given day.
     */
    @field:Json(name = "uvIndexTime")
    val uvIndexTime: Double? = null,

    /**
     * optional, only on daily
     *
     * The minimum temperature during a given date.
     */
    @field:Json(name = "temperatureMin")
    val temperatureMin: Double? = null,

    /**
     * optional, only on daily
     *
     * The UNIX time representing when the minimum temperature during a given date occurs.
     */
    @field:Json(name = "temperatureMinTime")
    val temperatureMinTime: Double? = null,

    /**
     * optional, only on daily
     *
     * The maximum temperature during a given date.
     */
    @field:Json(name = "temperatureMax")
    val temperatureMax: Double? = null,

    /**
     * optional, only on daily
     *
     * The UNIX time representing when the maximum temperature during a given date occurs.
     */
    @field:Json(name = "temperatureMaxTime")
    val temperatureMaxTime: Double? = null,

    /**
     * optional, only on daily
     *
    The minimum apparent temperature during a given date.
     */
    @field:Json(name = "apparentTemperatureMin")
    val apparentTemperatureMin: Double? = null,

    /**
     * optional, only on daily
     *
     * The UNIX time representing when the minimum apparent temperature during a given date occurs.
     */
    @field:Json(name = "apparentTemperatureMinTime")
    val apparentTemperatureMinTime: Double? = null,

    /**
     * optional, only on daily
     *
     * The maximum apparent temperature during a given date.
     */
    @field:Json(name = "apparentTemperatureMax")
    val apparentTemperatureMax: Double? = null,

    /**
     * optional, only on daily
     *
     * The UNIX time representing when the maximum apparent temperature during a given date occurs.
     */
    @field:Json(name = "apparentTemperatureMaxTime")
    val apparentTemperatureMaxTime: Double? = null,
    //</editor-fold>

    //<editor-fold desc="Hourly">
    /**
     * optional, only on hourly
     *
     * The air temperature in degrees Fahrenheit.
     */
    @field:Json(name = "temperature")
    val temperature: Double? = null,

    /**
     * optional, only on hourly
     *
    The apparent (or “feels like”) temperature in degrees Fahrenheit.
     */
    @field:Json(name = "apparentTemperature")
    val apparentTemperature: Double? = null,
    //</editor-fold>

    //<editor-fold desc="Currently">
    /**
     * optional, only on currently
     *
     * The approximate distance to the nearest storm in miles. (A storm distance of 0 doesn’t
     * necessarily refer to a storm at the requested location, but rather a storm in the vicinity
     * of that location.)
     */
    @field:Json(name = "nearestStormDistance")
    val nearestStormDistance: Double? = null
    //</editor-fold>
)