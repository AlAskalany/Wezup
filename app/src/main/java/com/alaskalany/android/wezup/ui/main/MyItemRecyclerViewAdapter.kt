package com.alaskalany.android.wezup.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alaskalany.android.model.data.period.DailyData
import com.alaskalany.android.model.enums.ForecastIcon
import com.alaskalany.android.wezup.R
import com.alaskalany.android.wezup.ui.main.MainFragment.OnListFragmentInteractionListener
import com.alaskalany.android.wezup.ui.main.dummy.DummyContent.DummyItem
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.fragment_item.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private var mValues: MutableList<DailyData?>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DailyData
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        if (item?.dummy == true) {
            animateItemLoading(holder, 1000, true)
            return
        }

        holder.mView.clearAnimation()

        animateItemLoaded(holder)

        holder.mDayTextView.text = item?.dayName
        holder.mWeatherSummaryTextView.text = item?.summary?.text
        holder.mTempMaxTextView.text =
            holder.mView.resources.getString(R.string.celsius, item?.temperatureHigh?.text)
        holder.mTempMinTextView.text =
            holder.mView.resources.getString(R.string.celsius, item?.temperatureLow?.text)

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }

        val icon = item?.icon
        holder.mImageViewIcon.setImageDrawable(
            holder.mView.context?.resources?.getDrawable(
                getWeatherIconDrawable(icon?.type)
            )
        )
    }

    private fun animateItemLoaded(holder: ViewHolder) {
        val animation = AnimationUtils.loadAnimation(
            holder.mView.context, android.R.anim.fade_in
        )
        animation.duration = 500
        holder.mView.startAnimation(animation)
    }

    private fun animateItemLoading(
        holder: ViewHolder, durationMs: Long, repeat: Boolean
    ) {
        val animation = AnimationUtils.loadAnimation(holder.mView.context, android.R.anim.fade_in)
        animation.interpolator = AnimationUtils.loadInterpolator(
            holder.mView.context, android.R.anim.accelerate_decelerate_interpolator
        )
        animation.duration = durationMs
        if (repeat) {
            animation.repeatCount = Animation.INFINITE
            animation.repeatMode = Animation.REVERSE
        }
        holder.mView.startAnimation(animation)
    }

    override fun getItemCount(): Int = mValues.size

    fun swap(list: List<DailyData?>) {
        val result = DiffUtil.calculateDiff(DailyDiffCallback(mValues, list), false)
        mValues = list.toMutableList()
        result.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val cardView: MaterialCardView = mView.cardLayout
        val mDayTextView: TextView = mView.textView_day
        val mWeatherSummaryTextView: TextView = mView.textView_weather_summary
        val mTempMaxTextView: TextView = mView.textView_temperature_max
        val mTempMinTextView: TextView = mView.textView_temperature_min
        val mImageViewIcon: ImageView = mView.imageView_icon

        override fun toString(): String {
            return super.toString() + " '" + mDayTextView.text + "'"
        }
    }
}

fun getWeatherIconDrawable(icon: ForecastIcon?): Int {
    return when (icon) {
        ForecastIcon.CLEAR_DAY -> {
            R.drawable.ic_sun
        }
        ForecastIcon.CLEAR_NIGHT -> {
            R.drawable.ic_night
        }
        ForecastIcon.PARTLY_CLOUDY_DAY -> {
            R.drawable.ic_cloudy_day
        }
        ForecastIcon.PARTLY_CLOUD_NIGHT -> {
            R.drawable.ic_cloudy_night
        }
        ForecastIcon.CLOUDY -> {
            R.drawable.ic_cloudy
        }
        ForecastIcon.RAIN -> {
            R.drawable.ic_rain
        }
        ForecastIcon.SLEET -> {
            R.drawable.ic_sleet
        }
        ForecastIcon.SNOW -> {
            R.drawable.ic_snow
        }
        ForecastIcon.WIND -> {
            R.drawable.ic_wind
        }
        ForecastIcon.FOG -> {
            R.drawable.ic_fog
        }
        ForecastIcon.UNKOWN -> {
            R.drawable.ic_clear_day
        }
        else -> {
            R.drawable.ic_clear_day
        }
    }
}
