package com.fantasyfang.developmenttool.repository.device

import com.fantasyfang.developmenttool.data.DeviceInfo
import com.fantasyfang.developmenttool.data.DeviceItem
import com.fantasyfang.developmenttool.data.Item
import com.fantasyfang.developmenttool.repository.LocalDataStore
import javax.inject.Inject

class DeviceInfoLocalDataStore @Inject constructor() : LocalDataStore<List<DeviceInfo>> {

    override fun getData(): List<DeviceInfo> {
        val build = android.os.Build.DISPLAY
        return listOf(
            DeviceInfo(Item(DeviceItem.DEVICE_NAME, android.os.Build.MODEL))
        )

    }
}