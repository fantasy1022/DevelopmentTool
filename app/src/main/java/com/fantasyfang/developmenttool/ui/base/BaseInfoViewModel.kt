package com.fantasyfang.developmenttool.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fantasyfang.developmenttool.repository.InfoRepository
import kotlinx.coroutines.*

abstract class BaseInfoViewModel<T>(
    private val infoRepository: InfoRepository<T>
) : ViewModel() {

    private var myJob: Job? = null

    open fun getInfo(): MutableLiveData<T> {
        val uiInfo: MutableLiveData<T> = MutableLiveData()

        myJob = GlobalScope.launch((Dispatchers.Main)) {
            try {
                withContext(Dispatchers.IO) {
                    val result = infoRepository.getInfo()
                    uiInfo.postValue(result)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                //TODO: How to handle error
            }
        }

        return uiInfo
    }
}