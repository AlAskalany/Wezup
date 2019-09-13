package com.alaskalany.android.wezup

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.alaskalany.android.model.data.period.DailyData
import com.alaskalany.android.wezup.databinding.MainActivityBinding
import com.alaskalany.android.wezup.ui.main.MainFragment
import com.alaskalany.android.wezup.ui.main.MainViewModel
import com.google.android.gms.location.*
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(),
    CoroutineScope,
    MainFragment.OnListFragmentInteractionListener {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job
    private lateinit var job: Job

    private lateinit var binding: MainActivityBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var locationCaptain: LocationCaptain
    private lateinit var locationRequest: LocationRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = SupervisorJob()
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance(1)).commitNow()
        }
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationProviderClient.lastLocation.addOnSuccessListener { location: Location? ->
            if (location != null) {
                launch {
                    viewModel.setLocation(location)
                }
            } else {
                // Do nothing
            }
        }

        val locationCallback = object : LocationCallback() {
            override fun onLocationResult(result: LocationResult?) {
                result?.let {
                    Log.d("locationCallback", "result: ${result.lastLocation}")
                }
            }

            override fun onLocationAvailability(availability: LocationAvailability?) {
                availability?.let {
                    Log.d("locationCallback", "availability: ${it.isLocationAvailable}")
                }
            }
        }

        locationRequest = LocationRequest().apply {
            interval = Companion.UPDATE_INTERVAL_IN_MILLISECONDS
            fastestInterval = Companion.FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }

        fusedLocationProviderClient.requestLocationUpdates(
            locationRequest, locationCallback, Looper.getMainLooper()
        )

        locationCaptain = LocationCaptain(this, lifecycle) {
            updateLocationInViewModel(it)
        }
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            locationCaptain.enable()
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
            }
        }
    }

    private fun updateLocationInViewModel(location: Location) {
        if (::viewModel.isInitialized) {
            launch {
                viewModel.setLocation(location)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    override fun onListFragmentInteraction(item: DailyData?) {
        Toast.makeText(this, "Item Clicked", Toast.LENGTH_SHORT).show()
    }

    companion object {
        private val UPDATE_INTERVAL_IN_MILLISECONDS: Long = TimeUnit.SECONDS.toMillis(10)
        private val FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = UPDATE_INTERVAL_IN_MILLISECONDS / 2
    }
}
