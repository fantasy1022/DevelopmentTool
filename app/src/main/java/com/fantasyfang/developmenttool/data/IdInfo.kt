package com.fantasyfang.developmenttool.data

import com.fantasyfang.developmenttool.R

class IdInfo(val item: Item<IdItem, String>) : InfoBase {
    override fun getStringId(): Int = item.name.value

    override fun getValue(): String = item.value
}

enum class IdItem(val value: Int) {
    ANDROID_ID(R.string.id_anndroid_id),
    IMEI(R.string.id_imei)
}