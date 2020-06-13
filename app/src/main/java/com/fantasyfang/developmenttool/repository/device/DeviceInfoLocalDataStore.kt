package com.fantasyfang.developmenttool.repository.device

import android.os.Build
import com.fantasyfang.developmenttool.data.DeviceInfo
import com.fantasyfang.developmenttool.data.DeviceItem
import com.fantasyfang.developmenttool.data.Item
import com.fantasyfang.developmenttool.repository.LocalDataStore
import javax.inject.Inject

class DeviceInfoLocalDataStore @Inject constructor() : LocalDataStore<List<DeviceInfo>> {

    override fun getData(): List<DeviceInfo> {
        val supportABI = Build.SUPPORTED_ABIS.reduce { sum, element -> "$sum, $element" }
        val support32ABI = Build.SUPPORTED_32_BIT_ABIS.reduce { sum, element -> "$sum, $element" }
        val support64ABI = Build.SUPPORTED_64_BIT_ABIS.reduce { sum, element -> "$sum, $element" }

        return listOf(
            DeviceInfo(Item(DeviceItem.MODEL, Build.MODEL)),
            DeviceInfo(Item(DeviceItem.BRAND, Build.BRAND)),
            DeviceInfo(Item(DeviceItem.MANUFACTURER, Build.MANUFACTURER)),
            DeviceInfo(Item(DeviceItem.SUPPORTED_ABIS, supportABI)),
            DeviceInfo(Item(DeviceItem.SUPPORTED_32_BIT_ABIS, support32ABI)),
            DeviceInfo(Item(DeviceItem.SUPPORTED_64_BIT_ABIS, support64ABI)),
            DeviceInfo(
                Item(
                    DeviceItem.ANDROID_VERSION_CODE,
                    Build.VERSION.SDK_INT.toString()
                )
            ),
            DeviceInfo(
                Item(
                    DeviceItem.ANDROID_VERSION,
                    Build.VERSION.RELEASE
                )
            ),
            DeviceInfo(Item(DeviceItem.BOARD, Build.BOARD)),
            DeviceInfo(Item(DeviceItem.BOOTLOADER, Build.BOOTLOADER)),
            DeviceInfo(Item(DeviceItem.DISPLAY, Build.DISPLAY)),
            DeviceInfo(Item(DeviceItem.FINGERPRINT, Build.FINGERPRINT)),
            DeviceInfo(Item(DeviceItem.HARDWARE, Build.HARDWARE)),
            DeviceInfo(Item(DeviceItem.HOST, Build.HOST)),
            DeviceInfo(Item(DeviceItem.ID, Build.ID)),
            DeviceInfo(Item(DeviceItem.PRODUCT, Build.PRODUCT)),
            DeviceInfo(Item(DeviceItem.TAGS, Build.TAGS)),
            DeviceInfo(Item(DeviceItem.TYPE, Build.TYPE)),
            DeviceInfo(Item(DeviceItem.USER, Build.USER))
        )
    }
}