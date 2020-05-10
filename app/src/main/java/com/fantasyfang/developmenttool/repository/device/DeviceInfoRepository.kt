package com.fantasyfang.developmenttool.repository.device

import com.fantasyfang.developmenttool.data.DeviceUIInfo

interface DeviceInfoRepository {
    fun getDeviceInfo(): DeviceUIInfo
}