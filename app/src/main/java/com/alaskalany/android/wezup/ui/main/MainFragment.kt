package com.alaskalany.android.wezup.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alaskalany.android.model.data.period.DailyData
import com.alaskalany.android.wezup.R
import com.alaskalany.android.wezup.databinding.MainFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

class MainFragment : Fragment(), CoroutineScope {

    //</editor-fold>

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var job: Job

    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: MainFragmentBinding

    private lateinit var recyclerView: RecyclerView

    private lateinit var myItemRecyclerViewAdapter: MyItemRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.lifecycleOwner = this
        viewModel = ViewModelProviders.of(requireActivity()).get(MainViewModel::class.java)
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
                if (!::recyclerView.isInitialized) {
                    recyclerView = binding.recyclerViewMain
                }
                if (!::myItemRecyclerViewAdapter.isInitialized) {
                    myItemRecyclerViewAdapter =
                        MyItemRecyclerViewAdapter(newList.toMutableList(), listener)
                    // Set the adapter
                    with(recyclerView) {
                        layoutManager = when {
                            columnCount <= 1 -> LinearLayoutManager(context)
                            else -> GridLayoutManager(context, columnCount)
                        }
                        adapter = myItemRecyclerViewAdapter
                    }
                }
                if (::myItemRecyclerViewAdapter.isInitialized) {
                    myItemRecyclerViewAdapter.swap(newList)
                }
            }
        })
        return binding.root
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

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {

        } else {

        }
    }

    private fun shortToast(s: String) {
        Toast.makeText(
            requireContext(), s, Toast.LENGTH_SHORT
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
        fun onListFragmentInteraction(item: DailyData?)
    }

    companion object {
        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) = MainFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_COLUMN_COUNT, columnCount)
            }
        }
    }
}
