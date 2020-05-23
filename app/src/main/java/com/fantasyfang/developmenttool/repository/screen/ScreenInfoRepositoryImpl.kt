package com.fantasyfang.developmenttool.repository.screen

import com.fantasyfang.developmenttool.data.ScreenInfo
import com.fantasyfang.developmenttool.repository.InfoRepository

class ScreenInfoRepositoryImpl(private val screenInfoLocalDataStore: ScreenInfoLocalDataStore) :
    InfoRepository<List<ScreenInfo>> {

    override fun getInfo(): List<ScreenInfo> = screenInfoLocalDataStore.getData()
}

