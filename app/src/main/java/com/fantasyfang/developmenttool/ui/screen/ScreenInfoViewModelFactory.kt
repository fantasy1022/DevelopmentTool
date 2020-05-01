package com.fantasyfang.developmenttool.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fantasyfang.developmenttool.repository.screen.ScreenInfoRepository

class ScreenInfoViewModelFactory(private val screenInfoRepository: ScreenInfoRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ScreenInfoViewModel(screenInfoRepository) as T
    }
}