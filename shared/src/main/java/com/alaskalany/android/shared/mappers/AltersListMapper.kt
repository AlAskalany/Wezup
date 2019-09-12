package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.Alert
import com.alaskalany.android.shared.dto.AlertDto

class AltersListMapper :
    DataMapper<List<AlertDto?>, List<Alert?>> {

    private val alertMapper = AlertMapper()

    override fun map(input: List<AlertDto?>?): List<Alert?>? {
        return input?.filterNotNull()?.map { alertMapper.map(it) }
    }
}