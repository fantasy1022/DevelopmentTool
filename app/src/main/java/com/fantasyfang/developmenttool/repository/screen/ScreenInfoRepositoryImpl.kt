package com.fantasyfang.developmenttool.repository.screen

import com.fantasyfang.developmenttool.data.ScreenUIInfo
import com.fantasyfang.developmenttool.repository.InfoRepository

class ScreenInfoRepositoryImpl(private val screenInfoLocalDataStore: ScreenInfoLocalDataStore) :
    InfoRepository<ScreenUIInfo> {

    override fun getInfo(): ScreenUIInfo = screenInfoLocalDataStore.getData()
}

