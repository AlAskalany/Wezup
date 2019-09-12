package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.Alert
import com.alaskalany.android.shared.dto.AlertDto

object AlertMapper :
    DataMapper<AlertDto, Alert> {

    override fun map(input: AlertDto?): Alert? {
        return if (input != null) {
            Alert(
                title = TitleMapper.map(input.title),
                regions = input.regions,
                severity = input.severity,
                time = TimeMapper.map(input.time),
                expires = input.expires,
                description = DescriptionMapper.map(input.description),
                uri = input.uri
            )
        } else {
            null
        }
    }
}