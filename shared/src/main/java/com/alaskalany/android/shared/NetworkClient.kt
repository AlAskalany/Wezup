package com.alaskalany.android.shared

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkClient {
    private val client = OkHttpClient()

    val instance: WeatherService by lazy {

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()


        val retrofit = Retrofit.Builder().apply {
            client(client)
            baseUrl("https://api.darksky.net/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
        }.build()
        retrofit.create(WeatherService::class.java)
    }
}