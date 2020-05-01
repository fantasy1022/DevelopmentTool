package com.fantasyfang.developmenttool.repository.screen

import com.fantasyfang.developmenttool.data.ScreenUIInfo


class ScreenInfoRepositoryImpl(private val screenInfoLocalDataStore: ScreenInfoLocalDataStore) :
    ScreenInfoRepository {
    override fun getScreenInfo(): ScreenUIInfo = screenInfoLocalDataStore.getData()
}

