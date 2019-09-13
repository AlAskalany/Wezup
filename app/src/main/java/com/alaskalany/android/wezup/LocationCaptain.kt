package com.alaskalany.android.wezup

import android.annotation.SuppressLint
import android.app.Service
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class LocationCaptain(
    private val context: Context,
    private val lifecycle: Lifecycle,
    private val callback: (Location) -> Unit
) : LifecycleObserver {

    private var enabled = false
    private lateinit var locationManager: LocationManager
    private val locationListener = MyLocationListener()

    init {
        lifecycle.addObserver(this)
    }

    @SuppressLint("MissingPermission")
    fun enable() {
        enabled = true
        locationManager = context.getSystemService(Service.LOCATION_SERVICE) as LocationManager
        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER, 1000L, 100.0F, locationListener
        )
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.d(TAG, "onStart")
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.d(TAG, "onStop")
        lifecycle.removeObserver(this)
    }

    inner class MyLocationListener : LocationListener {
        override fun onLocationChanged(location: Location?) {
            location?.let { callback(it) }
        }

        override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
        }

        override fun onProviderEnabled(p0: String?) {
        }

        override fun onProviderDisabled(p0: String?) {
        }
    }

    companion object {
        private const val TAG = "LocationCaptain"
    }
}