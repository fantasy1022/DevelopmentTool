package com.fantasyfang.developmenttool.ui.device

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fantasyfang.developmenttool.repository.device.DeviceInfoRepository

class DeviceInfoViewModelFactory(private val deviceInfoRepository: DeviceInfoRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DeviceInfoViewModel(deviceInfoRepository) as T
    }
}