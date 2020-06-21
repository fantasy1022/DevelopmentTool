package com.fantasyfang.developmenttool.repository.device

import androidx.lifecycle.LiveData
import com.fantasyfang.developmenttool.data.DeviceInfo
import com.fantasyfang.developmenttool.repository.InfoRepository

class DeviceInfoRepositoryImpl(private val deviceInfoLocalDataStore: DeviceInfoLocalDataStore) :
    InfoRepository<List<DeviceInfo>> {

    override suspend fun getInfo(): LiveData<List<DeviceInfo>> = deviceInfoLocalDataStore.getData()
}