package com.fantasyfang.developmenttool.repository.device

import android.os.Build
import com.fantasyfang.developmenttool.data.DeviceInfo
import com.fantasyfang.developmenttool.data.DeviceItem
import com.fantasyfang.developmenttool.data.Item
import com.fantasyfang.developmenttool.repository.LocalDataStore
import com.fantasyfang.developmenttool.repository.Result
import javax.inject.Inject

class DeviceInfoLocalDataStore @Inject constructor() : LocalDataStore<List<DeviceInfo>> {

    override fun getData(): List<DeviceInfo> {
        val supportABI = Build.SUPPORTED_ABIS.reduce { sum, element -> "$sum, $element" }
        val support32ABI = Build.SUPPORTED_32_BIT_ABIS.reduce { sum, element -> "$sum, $element" }
        val support64ABI = Build.SUPPORTED_64_BIT_ABIS.reduce { sum, element -> "$sum, $element" }

        return listOf(
            DeviceInfo(Item(DeviceItem.MODEL, Result.Success(Build.MODEL))),
            DeviceInfo(Item(DeviceItem.BRAND, Result.Success(Build.BRAND))),
            DeviceInfo(Item(DeviceItem.MANUFACTURER, Result.Success(Build.MANUFACTURER))),
            DeviceInfo(Item(DeviceItem.SUPPORTED_ABIS, Result.Success(supportABI))),
            DeviceInfo(Item(DeviceItem.SUPPORTED_32_BIT_ABIS, Result.Success(support32ABI))),
            DeviceInfo(Item(DeviceItem.SUPPORTED_64_BIT_ABIS, Result.Success(support64ABI))),
            DeviceInfo(
                Item(
                    DeviceItem.ANDROID_VERSION_CODE,
                    Result.Success(Build.VERSION.SDK_INT.toString())
                )
            ),
            DeviceInfo(
                Item(
                    DeviceItem.ANDROID_VERSION,
                    Result.Success(Build.VERSION.RELEASE)
                )
            ),
            DeviceInfo(Item(DeviceItem.BOARD, Result.Success(Build.BOARD))),
            DeviceInfo(Item(DeviceItem.BOOTLOADER, Result.Success(Build.BOOTLOADER))),
            DeviceInfo(Item(DeviceItem.DISPLAY, Result.Success(Build.DISPLAY))),
            DeviceInfo(Item(DeviceItem.FINGERPRINT, Result.Success(Build.FINGERPRINT))),
            DeviceInfo(Item(DeviceItem.HARDWARE, Result.Success(Build.HARDWARE))),
            DeviceInfo(Item(DeviceItem.HOST, Result.Success(Build.HOST))),
            DeviceInfo(Item(DeviceItem.ID, Result.Success(Build.ID))),
            DeviceInfo(Item(DeviceItem.PRODUCT, Result.Success(Build.PRODUCT))),
            DeviceInfo(Item(DeviceItem.TAGS, Result.Success(Build.TAGS))),
            DeviceInfo(Item(DeviceItem.TYPE, Result.Success(Build.TYPE))),
            DeviceInfo(Item(DeviceItem.USER, Result.Success(Build.USER)))
        )
    }
}