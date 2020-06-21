package com.fantasyfang.developmenttool.repository.id

import android.Manifest
import androidx.annotation.RequiresPermission
import androidx.lifecycle.LiveData
import com.fantasyfang.developmenttool.data.IdInfo
import com.fantasyfang.developmenttool.repository.InfoRepository

class IdInfoRepositoryImpl(private val idInfoLocalDataStore: IdInfoLocalDataStore) :
    InfoRepository<List<IdInfo>> {

    @RequiresPermission(Manifest.permission.READ_PHONE_STATE)
    override suspend fun getInfo(): LiveData<List<IdInfo>> = idInfoLocalDataStore.getData()
}