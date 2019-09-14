package com.alaskalany.android.wezup

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

class NetworkStateReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action != ConnectivityManager.CONNECTIVITY_ACTION) {
            return
        }
        val listener = networkStateListener
        if (listener != null) {
            context?.let { listener.onNetworkStateChanged(isConnected(it)) }
        }
    }

    private fun isConnected(context: Context): Boolean {
        val cm = context.getSystemService(Service.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnectedOrConnecting
    }

    interface NetworkStateListener {
        fun onNetworkStateChanged(connected: Boolean)
    }

    companion object {
        var networkStateListener: NetworkStateListener? = null
    }
}