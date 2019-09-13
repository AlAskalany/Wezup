package com.alaskalany.android.wezup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alaskalany.android.wezup.ui.main.MainViewModel

class MainViewModelFactory(
    private val application: WezupApplication
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(application) as T
    }
}