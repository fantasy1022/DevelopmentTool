package com.fantasyfang.developmenttool.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fantasyfang.developmenttool.repository.InfoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

abstract class BaseInfoViewModel<T>(
    private val infoRepository: InfoRepository<T>
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    open fun getInfo(): MutableLiveData<T> {
        val uiInfo: MutableLiveData<T> = MutableLiveData()

        launch(Dispatchers.IO) {
            val result = infoRepository.getInfo()
            uiInfo.postValue(result)
        }

        return uiInfo
    }
}