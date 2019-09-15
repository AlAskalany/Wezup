package com.alaskalany.android.wezup

import android.Manifest
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.location.Location
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alaskalany.android.model.data.period.DailyData
import com.alaskalany.android.wezup.databinding.MainActivityBinding
import com.alaskalany.android.wezup.ui.main.MainFragment
import com.alaskalany.android.wezup.ui.main.MainViewModel
import com.alaskalany.android.wezup.ui.main.OfflineFragment
import com.alaskalany.android.wezup.ui.main.SplashFragment
import com.google.android.gms.location.*
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(),
    CoroutineScope,
    MainFragment.OnListFragmentInteractionListener,
    NetworkStateReceiver.NetworkStateListener {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job
    private lateinit var job: Job
    val handler =
        CoroutineExceptionHandler { coroutineContext: CoroutineContext, throwable: Throwable ->
            Log.e("CoroutineExcepHandler", throwable.message, throwable)
        }
    private lateinit var binding: MainActivityBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var locationCaptain: LocationCaptain
    private lateinit var locationRequest: LocationRequest
    private lateinit var networkStateReceiver: NetworkStateReceiver
    override fun onNetworkStateChanged(connected: Boolean) {
        viewModel.setOnlineState(connected)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = SupervisorJob()
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().run {
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                replace(R.id.container, SplashFragment.newInstance("", ""), SplashFragment.TAG)
                commitNow()
            }
        }
        launch {
            delay(3000)
            networkStateReceiver = NetworkStateReceiver()
            registerReceiver(
                networkStateReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
            )
            viewModel = ViewModelProviders.of(
                this@MainActivity, MainViewModelFactory(application as WezupApplication)
            ).get(MainViewModel::class.java)

            viewModel.online.observe(this@MainActivity, Observer { isConnected ->
                supportFragmentManager.beginTransaction().run {
                    val (fragment, fragmentTag) = if (isConnected != null && isConnected == true) {
                        MainFragment.newInstance(1) to MainFragment.TAG
                    } else {
                        OfflineFragment.newInstance("", "") to OfflineFragment.TAG
                    }
                    setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    replace(R.id.container, fragment, fragmentTag)
                    commitNow()
                }
            })

            val fusedLocationProviderClient =
                LocationServices.getFusedLocationProviderClient(this@MainActivity)
            fusedLocationProviderClient.lastLocation.addOnSuccessListener { location: Location? ->
                if (location != null) {
                    launch(handler) {
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
                interval = UPDATE_INTERVAL_IN_MILLISECONDS
                fastestInterval = FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS
                priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            }

            fusedLocationProviderClient.requestLocationUpdates(
                locationRequest, locationCallback, Looper.getMainLooper()
            )

            locationCaptain = LocationCaptain(this@MainActivity, lifecycle) {
                updateLocationInViewModel(it)
            }
            if (ContextCompat.checkSelfPermission(
                    this@MainActivity, Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                locationCaptain.enable()
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        NetworkStateReceiver.networkStateListener = this
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::networkStateReceiver.isInitialized) {
            unregisterReceiver(networkStateReceiver)
        }
        if (::job.isInitialized) {
            job.cancel()
        }
    }

    private fun updateLocationInViewModel(location: Location) {
        if (::viewModel.isInitialized) {
            launch {
                viewModel.setLocation(location)
            }
        }
    }

    override fun onListFragmentInteraction(item: DailyData?) {

    }

    companion object {
        private val UPDATE_INTERVAL_IN_MILLISECONDS: Long = TimeUnit.SECONDS.toMillis(10)
        private val FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = UPDATE_INTERVAL_IN_MILLISECONDS / 2
    }
}

