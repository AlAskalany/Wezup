package com.alaskalany.android.model

interface IForecast {
    val latitude: Double?
    val longitude: Double?
    val timezone: String?
    val currently: ICurrently?
    val hourly: IHourly?
    val daily: IDaily?
    val alerts: List<IAlert?>?
    val flags: IFlags?
}