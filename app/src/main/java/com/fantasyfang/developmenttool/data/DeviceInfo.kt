package com.fantasyfang.developmenttool.data

import com.fantasyfang.developmenttool.R

data class DeviceInfo(val item: Item<DeviceItem, String>) : InfoBase {
    override fun getStringId(): Int = item.name.value

    override fun getValue(): String = item.value
}

enum class DeviceItem(val value: Int) {
    DEVICE_NAME(R.string.device_name)
}
