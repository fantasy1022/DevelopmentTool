package com.fantasyfang.developmenttool.repository.id

import android.Manifest
import android.content.Context
import androidx.annotation.RequiresPermission
import com.fantasyfang.developmenttool.data.IdInfo
import com.fantasyfang.developmenttool.data.IdItem
import com.fantasyfang.developmenttool.data.Item
import com.fantasyfang.developmenttool.extension.getAndroidId
import com.fantasyfang.developmenttool.extension.getDeviceIMEI
import com.fantasyfang.developmenttool.extension.getIPV4Address
import com.fantasyfang.developmenttool.repository.LocalDataStore
import javax.inject.Inject

class IdInfoLocalDataStore @Inject constructor(private val context: Context) :
    LocalDataStore<List<IdInfo>> {

    @RequiresPermission(Manifest.permission.READ_PHONE_STATE)
    override fun getData(): List<IdInfo> {
        return listOf(
            IdInfo(Item(IdItem.ANDROID_ID, context.getAndroidId())),
            IdInfo(Item(IdItem.IMEI, context.getDeviceIMEI())),
            IdInfo(Item(IdItem.LOCAL_IP, context.getIPV4Address()))
        )
    }

}