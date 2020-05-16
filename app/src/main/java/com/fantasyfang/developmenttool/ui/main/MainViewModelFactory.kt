package com.fantasyfang.developmenttool.ui.main

import androidx.lifecycle.SavedStateHandle
import com.fantasyfang.developmenttool.Repository
import com.fantasyfang.developmenttool.di.ViewModelAssistedFactory
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val repository: Repository
) : ViewModelAssistedFactory<MainViewModel> {
    override fun create(handle: SavedStateHandle): MainViewModel {
        return MainViewModel(
            handle,
            repository
        )
    }
}