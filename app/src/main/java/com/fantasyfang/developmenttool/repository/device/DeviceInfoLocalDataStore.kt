package com.fantasyfang.developmenttool.repository.device

import com.fantasyfang.developmenttool.data.DeviceInfo
import com.fantasyfang.developmenttool.data.DeviceItem
import com.fantasyfang.developmenttool.data.DeviceUIInfo
import com.fantasyfang.developmenttool.data.Item
import com.fantasyfang.developmenttool.repository.LocalDataStore
import javax.inject.Inject

class DeviceInfoLocalDataStore @Inject constructor() : LocalDataStore<DeviceUIInfo> {

    override fun getData(): DeviceUIInfo {
        val build = android.os.Build.DISPLAY
        return DeviceUIInfo(
            listOf(
                DeviceInfo(Item(DeviceItem.DEVICE_NAME, android.os.Build.MODEL))
            )
        )
    }
}