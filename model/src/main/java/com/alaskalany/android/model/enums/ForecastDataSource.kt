package com.alaskalany.android.model.enums

/**
 * The Dark Sky API is backed by a wide range of weather data sources, which are aggregated
 * together to provide the most accurate forecast possible for a given location. Any data sources
 * used to service a given request will be noted in the flags section of the API response.
 */
@Suppress("unused")
enum class ForecastDataSource(val value: String) {

    /**
     * The USA NCEP’s Canadian Meteorological Center ensemble model, available globally.
     */
    CMC("cmc"),
    /**
     * Dark Sky’s own hyperlocal precipitation forecasting system, backed by radar data from the
     * USA NOAA’s NEXRAD system, available in the USA, and the UK Met Office’s NIMROD system,
     * available in the UK and Ireland.
     */
    DARKSKY("darksky"),
    /**
     * Environment and Climate Change Canada's Public Alert system, available in Canada.
     */
    ECPA("ecpa"),
    /**
     * The USA NOAA’s Global Forecast System, available globally.
     */
    GFS("gfs"),
    /**
     * The USA NOAA's High-Resolution Rapid Refresh Model, available in the continental USA.
     */
    HRRR("hrrr"),
    /**
     * The German Meteorological Office's icosahedral nonhydrostatic, available globally.
     */
    ICON("icon"),
    /**
     * The Icelandic Meteorological Office's Severe Weather Alerting system, avaialble in Iceland.
     */
    IMO("imo"),
    /**
     * The USA NOAA’s Integrated Surface Database, available near populated areas globally for
     * times greater than two weeks in the past.
     */
    ISD("isd"),
    /**
     * The USA NOAA/ESRL’s Meteorological Assimilation Data Ingest System, available near populated
     * areas globally.
     */
    MADIS("madis"),
    /**
     * EUMETNET's Meteoalarm weather alerting system, available in European Union countries
     * and Israel.
     */
    METEOALARM("meteoalarm"),
    /**
     * The USA NOAA’s North American Mesoscale Model, available in North America.
     */
    NAM("nam"),
    /**
     * The USA NOAA’s Public Alert system, available in the USA.
     */
    NWSPA("nwspa"),
    /**
     * The USA NOAA/NCEP’s Short-Range Ensemble Forecast, available in North America.
     */
    SREF("sref"),
}