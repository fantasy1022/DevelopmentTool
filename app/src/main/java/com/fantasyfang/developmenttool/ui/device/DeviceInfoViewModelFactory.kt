package com.fantasyfang.developmenttool.ui.device

import androidx.lifecycle.SavedStateHandle
import com.fantasyfang.developmenttool.di.ViewModelAssistedFactory
import com.fantasyfang.developmenttool.repository.device.DeviceInfoRepository
import javax.inject.Inject

class DeviceInfoViewModelFactory @Inject constructor(
    private val deviceInfoRepository: DeviceInfoRepository
) : ViewModelAssistedFactory<DeviceInfoViewModel> {

    override fun create(handle: SavedStateHandle): DeviceInfoViewModel =
        DeviceInfoViewModel(handle, deviceInfoRepository)

}