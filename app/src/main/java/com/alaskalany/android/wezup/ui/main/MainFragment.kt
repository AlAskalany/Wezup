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
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.alaskalany.android.model.IDailyData
import com.alaskalany.android.wezup.R
import com.alaskalany.android.wezup.databinding.MainFragmentBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainFragment : Fragment(), CoroutineScope, LocationListener {

    //</editor-fold>

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job
    private lateinit var job: Job
    private var columnCount = 1
    private var listener: OnListFragmentInteractionListener? = null
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private lateinit var locationManager: LocationManager
    private val dailyDataList: MutableList<IDailyData?> = mutableListOf()
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
                dailyDataList.clear()
                dailyDataList.addAll(it)
                binding.recyclerViewMain.adapter?.notifyDataSetChanged()
            }
        })

        locationManager = activity?.getSystemService(Service.LOCATION_SERVICE) as LocationManager
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                1000L,
                100.0F,
                this
            )
        } else {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
        }
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

    //<editor-fold desc="LocationListener">
    override fun onLocationChanged(location: Location?) {
        if (::viewModel.isInitialized) {
            location?.latitude?.toString()?.let { viewModel.setLatitude(it) }
            location?.longitude?.toString()?.let { viewModel.setLongitude(it) }
            launch {
                viewModel.setLocation(location)
            }
        }
    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
        shortToast("statusChanged $p0")
    }

    override fun onProviderEnabled(p0: String?) {
        shortToast("providerEnabled $p0")
    }

    override fun onProviderDisabled(p0: String?) {
        shortToast("providerDisabled $p0")
    }

    private fun shortToast(s: String) {
        Toast.makeText(
            requireContext(),
            s,
            Toast.LENGTH_SHORT
        ).show()
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
