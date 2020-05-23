package com.fantasyfang.developmenttool.ui.device

import androidx.lifecycle.SavedStateHandle
import com.fantasyfang.developmenttool.data.DeviceInfo
import com.fantasyfang.developmenttool.di.ViewModelAssistedFactory
import com.fantasyfang.developmenttool.repository.InfoRepository
import javax.inject.Inject

class DeviceInfoViewModelFactory @Inject constructor(
    private val deviceInfoRepository: InfoRepository<List<DeviceInfo>>
) : ViewModelAssistedFactory<DeviceInfoViewModel> {

    override fun create(handle: SavedStateHandle): DeviceInfoViewModel =
        DeviceInfoViewModel(handle, deviceInfoRepository)

}