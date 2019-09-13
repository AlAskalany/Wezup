package com.alaskalany.android.wezup

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.alaskalany.android.model.data.period.DailyData
import com.alaskalany.android.wezup.databinding.MainActivityBinding
import com.alaskalany.android.wezup.ui.main.MainFragment
import com.alaskalany.android.wezup.ui.main.MainViewModel
import kotlinx.coroutines.*
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = SupervisorJob()
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance(1)).commitNow()
        }
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
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
}
