package com.fantasyfang.developmenttool.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.fantasyfang.developmenttool.repository.InfoRepository
import kotlinx.coroutines.Dispatchers

abstract class BaseInfoViewModel<T>(
    private val infoRepository: InfoRepository<T>
) : ViewModel() {

    open fun getInfo(): LiveData<T> = liveData(context = Dispatchers.IO) {
        emitSource(infoRepository.getInfo())
    }

}