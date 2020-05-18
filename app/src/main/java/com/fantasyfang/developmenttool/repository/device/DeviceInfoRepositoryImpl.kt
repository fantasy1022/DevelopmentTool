package com.fantasyfang.developmenttool.repository.device

import com.fantasyfang.developmenttool.data.DeviceUIInfo
import com.fantasyfang.developmenttool.repository.InfoRepository

class DeviceInfoRepositoryImpl(private val deviceInfoLocalDataStore: DeviceInfoLocalDataStore) :
    InfoRepository<DeviceUIInfo> {
    override fun getInfo(): DeviceUIInfo = deviceInfoLocalDataStore.getData()
}