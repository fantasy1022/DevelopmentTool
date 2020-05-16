package com.fantasyfang.developmenttool.ui.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.fantasyfang.developmenttool.Repository

class MainViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val repository: Repository
) : ViewModel() {

    fun getResult(): String = repository.getMessage()
}