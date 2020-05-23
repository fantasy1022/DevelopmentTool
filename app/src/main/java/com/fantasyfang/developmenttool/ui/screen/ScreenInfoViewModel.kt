package com.fantasyfang.developmenttool.ui.screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.fantasyfang.developmenttool.data.ScreenInfo
import com.fantasyfang.developmenttool.repository.InfoRepository
import kotlinx.coroutines.*

class ScreenInfoViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val screenInfoRepository: InfoRepository<List<ScreenInfo>>
) : ViewModel() {
    private var myJob: Job? = null

    fun getScreenInfos(): MutableLiveData<List<ScreenInfo>> {
        val screenUIInfo: MutableLiveData<List<ScreenInfo>> = MutableLiveData()

        myJob = GlobalScope.launch((Dispatchers.Main)) {
            try {
                withContext(Dispatchers.IO) {
                    val result = screenInfoRepository.getInfo()
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
