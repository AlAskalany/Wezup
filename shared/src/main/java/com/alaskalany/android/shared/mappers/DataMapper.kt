package com.alaskalany.android.shared.mappers

interface DataMapper<I, O> {
    fun map(input: I?): O?
}