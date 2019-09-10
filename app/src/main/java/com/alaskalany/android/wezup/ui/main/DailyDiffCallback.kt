package com.alaskalany.android.wezup.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.alaskalany.android.model.IDailyData

class DailyDiffCallback(
    private var oldList: List<IDailyData?>? = null,
    private var newList: List<IDailyData?>? = null
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItemPosition == newItemPosition

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        false

    override fun getOldListSize(): Int = oldList?.size ?: 0

    override fun getNewListSize(): Int = newList?.size ?: 0
}