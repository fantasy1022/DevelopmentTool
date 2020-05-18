package com.fantasyfang.developmenttool.ui.device

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.fantasyfang.developmenttool.data.DeviceUIInfo
import com.fantasyfang.developmenttool.repository.device.DeviceInfoRepository
import kotlinx.coroutines.*

class DeviceInfoViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val deviceInfoRepository: DeviceInfoRepository
) : ViewModel() {
    private var myJob: Job? = null

    fun getDeviceInfo(): MutableLiveData<DeviceUIInfo> {
        val deviceUIInfo: MutableLiveData<DeviceUIInfo> = MutableLiveData()

        myJob = GlobalScope.launch((Dispatchers.Main)) {
            try {
                withContext(Dispatchers.IO) {
                    val result = deviceInfoRepository.getDeviceInfo()
                    deviceUIInfo.postValue(result)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                //TODO: How to handle error
            }
        }

        return deviceUIInfo
    }

}
