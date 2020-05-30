package com.fantasyfang.developmenttool.repository.id

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import androidx.annotation.RequiresPermission
import com.fantasyfang.developmenttool.data.IdInfo
import com.fantasyfang.developmenttool.data.IdItem
import com.fantasyfang.developmenttool.data.Item
import com.fantasyfang.developmenttool.extension.getDeviceIMEI
import com.fantasyfang.developmenttool.repository.LocalDataStore
import javax.inject.Inject

class IdInfoLocalDataStore @Inject constructor(private val context: Context) :
    LocalDataStore<List<IdInfo>> {

    @SuppressLint("HardwareIds")
    @RequiresPermission(Manifest.permission.READ_PHONE_STATE)
    override fun getData(): List<IdInfo> {
        return listOf(
            IdInfo(
                Item(
                    IdItem.ANDROID_ID, Settings.Secure.getString(
                        context.contentResolver,
                        Settings.Secure.ANDROID_ID
                    )
                )
            ),
            IdInfo(Item(IdItem.IMEI, context.getDeviceIMEI()))
        )
    }


}