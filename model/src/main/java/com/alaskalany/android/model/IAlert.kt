package com.alaskalany.android.model

interface IAlert {
    val title: String?
    val regions: List<String?>?
    val severity: String?
    val time: Double?
    val expires: Double?
    val description: String?
    val uri: String?
}