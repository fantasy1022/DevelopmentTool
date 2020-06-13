package com.fantasyfang.developmenttool.data

import com.fantasyfang.developmenttool.R
import com.fantasyfang.developmenttool.repository.Result

class IdInfo(val item: Item<IdItem, Result>) : InfoBase {
    override fun getStringId(): Int = item.name.value

    override fun getValue(): Result = item.value
}

enum class IdItem(val value: Int) {
    ANDROID_ID(R.string.id_anndroid_id),
    IMEI(R.string.id_imei),
    LOCAL_IP(R.string.id_local_ip_address),
}