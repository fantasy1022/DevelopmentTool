package com.fantasyfang.developmenttool.data

import com.fantasyfang.developmenttool.R

data class DeviceInfo(val item: Item<DeviceItem, String>) : InfoBase {
    override fun getStringId(): Int = item.name.value

    override fun getValue(): String = item.value
}

enum class DeviceItem(val value: Int) {
    MODEL(R.string.device_model),
    ANDROID_VERSION_CODE(R.string.device_android_version_code),
    ANDROID_VERSION(R.string.device_android_version),
    BOARD(R.string.device_board),
    BOOTLOADER(R.string.device_bootloader),
    BRAND(R.string.device_brand),
    SUPPORTED_ABIS(R.string.device_supported_abis),
    DISPLAY(R.string.device_display),
    FINGERPRINT(R.string.device_fingerprint),
    HARDWARE(R.string.device_hardware),
    HOST(R.string.device_host),
    ID(R.string.device_id),
    MANUFACTURER(R.string.device_manufacturer),
    PRODUCT(R.string.device_product),
    SUPPORTED_32_BIT_ABIS(R.string.device_supported_32_abis),
    SUPPORTED_64_BIT_ABIS(R.string.device_supported_64_abis),
    TAGS(R.string.device_tags),
    TYPE(R.string.device_type),
    USER(R.string.device_user)
}
