package com.fantasyfang.developmenttool.repository.id

import com.fantasyfang.developmenttool.data.IdInfo
import com.fantasyfang.developmenttool.repository.InfoRepository

class IdInfoRepositoryImpl(private val idInfoLocalDataStore: IdInfoLocalDataStore) :
    InfoRepository<List<IdInfo>> {
    override fun getInfo(): List<IdInfo> = idInfoLocalDataStore.getData()
}