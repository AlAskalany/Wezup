package com.alaskalany.android.wezup.ui.main

import android.Manifest
import android.app.Service
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.annotation.RequiresPermission
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.alaskalany.android.model.IDailyData
import com.alaskalany.android.wezup.BuildConfig
import com.alaskalany.android.wezup.R
import com.alaskalany.android.wezup.databinding.MainFragmentBinding
import kotlinx.coroutines.*
import java.util.*
import kotlin.coroutines.CoroutineContext

class MainFragment : Fragment(), CoroutineScope {

    private var latitude: Double? = null
    private var longitude: Double? = null
    private var gpsLocation: Location? = null
    private var networkLocation: Location? = null
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job
    private lateinit var job: Job
    private var columnCount = 1
    private var listener: OnListFragmentInteractionListener? = null
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private val locationManager: LocationManager by lazy {
        activity?.getSystemService(Service.LOCATION_SERVICE) as LocationManager
    }
    private val dailyDataList: MutableList<IDailyData?> = mutableListOf()
    private lateinit var timer: Timer
    private val gpsLocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location?) {
            if (::viewModel.isInitialized) {
                setLatLongFromLocation(location)
                launch {
                    updateLocationInViewModel()
                }
            }
        }

        override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
            if (BuildConfig.DEBUG) {
                "statusChanged $p0".shortToast()
            }
        }

        override fun onProviderEnabled(p0: String?) {
            if (BuildConfig.DEBUG) {
                "providerEnabled $p0".shortToast()
            }
        }

        override fun onProviderDisabled(p0: String?) {
            if (BuildConfig.DEBUG) {
                "providerDisabled $p0".shortToast()
            }
        }
    }
    private val networkLocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location?) {
            if (::viewModel.isInitialized) {
                setLatLongFromLocation(location)
                launch {
                    updateLocationInViewModel()
                }
            }
        }

        override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
            if (BuildConfig.DEBUG) {
                "statusChanged $p0".shortToast()
            }
        }

        override fun onProviderEnabled(p0: String?) {
            if (BuildConfig.DEBUG) {
                "providerEnabled $p0".shortToast()
            }
        }

        override fun onProviderDisabled(p0: String?) {
            if (BuildConfig.DEBUG) {
                "providerDisabled $p0".shortToast()
            }
        }
    }
    private var gpsLocationEnabled: Boolean = false
    private var networkLocationEnabled: Boolean = false
    var taskNum = 0
    private var lastLocationTimerTask: LastLocationTimerTask? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.lifecycleOwner = this
        val view = binding.root
        val recyclerView = binding.recyclerViewMain
        // Set the adapter
        with(recyclerView) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = MyItemRecyclerViewAdapter(dailyDataList, listener)
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        job = SupervisorJob()
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
        job.cancel()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.model = viewModel

        viewModel.weatherIcon.observe(this, Observer { icon ->
            icon?.let {
                binding.imageViewCurrentWeatherIcon.setImageDrawable(
                    resources.getDrawable(
                        getWeatherIconDrawable(it)
                    )
                )
            }
        })

        viewModel.daily.observe(this, Observer { newList ->
            newList?.let {
                it.updateDailyList(dailyDataList)
                binding.recyclerViewMain.adapter?.notifyDataSetChanged()
            }
        })
        gpsLocationEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        networkLocationEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            if (!gpsLocationEnabled && !networkLocationEnabled) {
                if (BuildConfig.DEBUG) {
                    Toast.makeText(
                        requireContext(),
                        "GPS and Network locations are disabled",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            } else {

            }

            if (gpsLocationEnabled) {
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    1000L,
                    100.0F,
                    gpsLocationListener
                )
            }
            if (networkLocationEnabled) {
                locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    1000L,
                    100.0F,
                    networkLocationListener
                )
            }
        } else {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
        }

    }

    override fun onStart() {
        super.onStart()
        timer = Timer()
        lastLocationTimerTask = LastLocationTimerTask()
        timer.schedule(lastLocationTimerTask, 1000, 1000)
    }

    override fun onPause() {
        super.onPause()
        timer.cancel()
        lastLocationTimerTask = null
    }

    private fun List<IDailyData?>.updateDailyList(
        list: MutableList<IDailyData?>
    ) {
        list.clear()
        list.addAll(this)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {

        } else {

        }
    }

    private fun String.shortToast() {
        Toast.makeText(
            requireContext(),
            this,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun updateLocationData(
        gpsLocation1: Location?,
        networkLocation1: Location?
    ) {
        if (gpsLocation1 != null && networkLocation1 != null) {
            if (gpsLocation1.time > networkLocation1.time) {
                gpsLocation1.let {
                    latitude = it.latitude
                    longitude = it.longitude
                }
            } else {
                networkLocation1.let {
                    latitude = it.latitude
                    longitude = it.longitude
                }
            }
        }
        setLatLongFromLocation(gpsLocation1)
        setLatLongFromLocation(networkLocation1)
        launch {
            updateLocationInViewModel()
        }
    }

    private suspend fun updateLocationInViewModel() {
        viewModel.setLatLongInViewModel(
            latitude?.toString(),
            longitude?.toString()
        )
        viewModel.setLocationInViewModel()
    }

    private fun setLatLongFromLocation(gpsLocation1: Location?) {
        gpsLocation1?.let {
            latitude = it.latitude
            longitude = it.longitude
        }
    }

    @MainThread
    private suspend fun MainViewModel.setLatLongInViewModel(
        lat: String?,
        long: String?
    ) =
        withContext(Dispatchers.Main) {
            lat?.let { setLatitude(it) }
            long?.let { setLongitude(it) }
        }

    private suspend fun MainViewModel.setLocationInViewModel() {
        setLocation(
            latitude.toString(), longitude.toString()
        )
    }

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION])
    private fun getLastKnownLocation() {
        if (gpsLocationEnabled) {
            gpsLocation =
                locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        }
        if (networkLocationEnabled) {
            networkLocation =
                locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: IDailyData?)
    }

    inner class LastLocationTimerTask : TimerTask() {
        override fun run() {
            if (BuildConfig.DEBUG) {
                launch {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(requireContext(), "task ${taskNum++}", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
            gpsLocation = null
            networkLocation = null
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                getLastKnownLocation()
                updateLocationData(gpsLocation, networkLocation)
            } else {
                requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
            }
        }

    }

    companion object {
        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
