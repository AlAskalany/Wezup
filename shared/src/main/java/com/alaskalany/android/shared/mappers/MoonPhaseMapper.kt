package com.alaskalany.android.shared.mappers

import com.alaskalany.android.model.data.MoonPhase
import com.alaskalany.android.shared.DataMapper

object MoonPhaseMapper : DataMapper<Double, MoonPhase> {
    override fun map(input: Double?): MoonPhase {
        return if (input != null) {
            MoonPhase(input)
        } else {
            MoonPhase()
        }
    }
}
