package com.fantasyfang.developmenttool.ui.device

import androidx.lifecycle.SavedStateHandle
import com.fantasyfang.developmenttool.data.DeviceUIInfo
import com.fantasyfang.developmenttool.di.ViewModelAssistedFactory
import com.fantasyfang.developmenttool.repository.InfoRepository
import javax.inject.Inject

class DeviceInfoViewModelFactory @Inject constructor(
    private val deviceInfoRepository: InfoRepository<DeviceUIInfo>
) : ViewModelAssistedFactory<DeviceInfoViewModel> {

    override fun create(handle: SavedStateHandle): DeviceInfoViewModel =
        DeviceInfoViewModel(handle, deviceInfoRepository)

}