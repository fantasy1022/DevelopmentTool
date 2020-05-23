package com.fantasyfang.developmenttool.repository.device

import com.fantasyfang.developmenttool.data.DeviceInfo
import com.fantasyfang.developmenttool.repository.InfoRepository

class DeviceInfoRepositoryImpl(private val deviceInfoLocalDataStore: DeviceInfoLocalDataStore) :
    InfoRepository<List<DeviceInfo>> {
    override fun getInfo(): List<DeviceInfo> = deviceInfoLocalDataStore.getData()
}