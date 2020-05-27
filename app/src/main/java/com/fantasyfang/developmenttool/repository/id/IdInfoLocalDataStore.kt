package com.fantasyfang.developmenttool.repository.id

import android.content.Context
import com.fantasyfang.developmenttool.data.IdInfo
import com.fantasyfang.developmenttool.repository.LocalDataStore
import javax.inject.Inject

class IdInfoLocalDataStore @Inject constructor(private val context: Context) :
    LocalDataStore<List<IdInfo>> {

    override fun getData(): List<IdInfo> {
        return emptyList()
    }
}