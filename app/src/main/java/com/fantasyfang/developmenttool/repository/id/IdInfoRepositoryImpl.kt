package com.fantasyfang.developmenttool.repository.id

import android.Manifest
import androidx.annotation.RequiresPermission
import com.fantasyfang.developmenttool.data.IdInfo
import com.fantasyfang.developmenttool.repository.InfoRepository

class IdInfoRepositoryImpl(private val idInfoLocalDataStore: IdInfoLocalDataStore) :
    InfoRepository<List<IdInfo>> {

    @RequiresPermission(Manifest.permission.READ_PHONE_STATE)
    override fun getInfo(): List<IdInfo> = idInfoLocalDataStore.getData()
}