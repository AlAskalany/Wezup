package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.Alerts
import com.alaskalany.android.shared.DataMapper
import com.alaskalany.android.shared.dto.AlertDto

object AltersListMapper :
    DataMapper<List<AlertDto?>, Alerts> {

    override fun map(input: List<AlertDto?>?): Alerts {
        return input?.filterNotNull()?.map { AlertMapper.map(it) }?.let { Alerts(it) } ?: Alerts()
    }
}