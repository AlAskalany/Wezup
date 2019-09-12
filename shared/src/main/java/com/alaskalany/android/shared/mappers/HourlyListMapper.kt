package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.Hourly
import com.alaskalany.android.shared.DataMapper
import com.alaskalany.android.shared.dto.DataBlock

object HourlyListMapper :
    DataMapper<DataBlock, Hourly> {

    override fun map(input: DataBlock?): Hourly? {
        return if (input != null) {
            Hourly(
                summary = SummaryMapper.map(input.summary),
                icon = ForecastIconMapper.map(input.icon),
                data = input.data?.map { dataPoint -> dataPoint?.let { HourlyMapper.map(it) } }
            )
        } else {
            null
        }
    }
}