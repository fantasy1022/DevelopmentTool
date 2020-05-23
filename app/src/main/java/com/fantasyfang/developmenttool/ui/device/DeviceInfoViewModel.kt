package com.fantasyfang.developmenttool.ui.device

import androidx.lifecycle.SavedStateHandle
import com.fantasyfang.developmenttool.data.DeviceInfo
import com.fantasyfang.developmenttool.repository.InfoRepository
import com.fantasyfang.developmenttool.ui.base.BaseInfoViewModel

class DeviceInfoViewModel(
    private val savedStateHandle: SavedStateHandle,
    deviceInfoRepository: InfoRepository<List<DeviceInfo>>
) : BaseInfoViewModel<List<DeviceInfo>>(deviceInfoRepository)

