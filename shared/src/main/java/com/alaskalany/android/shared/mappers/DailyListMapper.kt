package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.Daily
import com.alaskalany.android.shared.dto.DataBlock

object DailyListMapper :
    DataMapper<DataBlock, Daily> {


    override fun map(input: DataBlock?): Daily? {
        return if (input != null) {
            Daily(
                summary = SummaryMapper.map(input.summary),
                icon = ForecastIconMapper.map(input.icon),
                data = input.data?.map { dataPoint -> dataPoint?.let { DailyMapper.map(it) } }
            )
        } else {
            null
        }
    }
}