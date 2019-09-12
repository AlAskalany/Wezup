package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.Daily
import com.alaskalany.android.shared.dto.DataBlock

class DailyListMapper :
    DataMapper<DataBlock, Daily> {

    private val dailyMapper = DailyMapper()

    override fun map(input: DataBlock?): Daily? {
        return if (input != null) {
            Daily(
                input.summary,
                input.icon,
                input.data?.map { dataPoint -> dataPoint?.let { dailyMapper.map(it) } }
            )
        } else {
            null
        }
    }
}