package com.fantasyfang.developmenttool.ui.screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.fantasyfang.developmenttool.data.ScreenUIInfo
import com.fantasyfang.developmenttool.repository.screen.ScreenInfoRepository
import kotlinx.coroutines.*

class ScreenInfoViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val screenInfoRepository: ScreenInfoRepository
) : ViewModel() {
    private var myJob: Job? = null

    fun getScreenInfos(): MutableLiveData<ScreenUIInfo> {
        val screenUIInfo: MutableLiveData<ScreenUIInfo> = MutableLiveData()

        myJob = GlobalScope.launch((Dispatchers.Main)) {
            try {
                withContext(Dispatchers.IO) {
                    val result = screenInfoRepository.getScreenInfo()
                    screenUIInfo.postValue(result)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                //TODO: How to handle error
            }
        }

        return screenUIInfo
    }

}
