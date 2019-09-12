package com.alaskalany.android.model.data

abstract class TextData(override val value: String) : Data<String>(value) {
    open val text: String
        get() = value
}