package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.Hourly
import com.alaskalany.android.shared.dto.DataBlock

class HourlyListMapper :
    DataMapper<DataBlock, Hourly> {

    private val hourlyMapper = HourlyMapper()

    override fun map(input: DataBlock?): Hourly? {
        return if (input != null) {
            Hourly(
                input.summary,
                input.icon,
                input.data?.map { dataPoint -> dataPoint?.let { hourlyMapper.map(it) } }
            )
        } else {
            null
        }
    }
}