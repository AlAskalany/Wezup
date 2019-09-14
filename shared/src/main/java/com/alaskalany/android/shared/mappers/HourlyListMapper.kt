package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.Hourly
import com.alaskalany.android.model.data.HourlyDataList
import com.alaskalany.android.shared.DataMapper
import com.alaskalany.android.shared.dto.DataBlock

object HourlyListMapper :
    DataMapper<DataBlock, Hourly> {

    override fun map(input: DataBlock?): Hourly? {
        return if (input != null) {
            val data = input.data?.map { dataPoint -> dataPoint?.let { HourlyMapper.map(it) } }
            val hourlyDataList = HourlyDataList()
            data?.forEach {
                hourlyDataList.add(it)
            }
            Hourly(
                summary = SummaryMapper.map(input.summary),
                icon = ForecastIconMapper.map(input.icon),
                data = hourlyDataList
            )
        } else {
            null
        }
    }
}