package com.fantasyfang.developmenttool.repository.device

import com.fantasyfang.developmenttool.data.DeviceUIInfo

class DeviceInfoRepositoryImpl(private val deviceInfoLocalDataStore: DeviceInfoLocalDataStore) :
    DeviceInfoRepository {
    override fun getDeviceInfo(): DeviceUIInfo = deviceInfoLocalDataStore.getData()
}