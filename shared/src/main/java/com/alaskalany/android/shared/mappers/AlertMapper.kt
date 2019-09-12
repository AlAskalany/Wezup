package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.Alert
import com.alaskalany.android.shared.dto.AlertDto

class AlertMapper :
    DataMapper<AlertDto, Alert> {

    override fun map(input: AlertDto?): Alert? {
        return if (input != null) {
            Alert(
                input.title,
                input.regions,
                input.severity,
                input.time,
                input.expires,
                input.description,
                input.uri
            )
        } else {
            null
        }
    }
}