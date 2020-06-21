package com.fantasyfang.developmenttool.repository.screen

import androidx.lifecycle.LiveData
import com.fantasyfang.developmenttool.data.ScreenInfo
import com.fantasyfang.developmenttool.repository.InfoRepository

class ScreenInfoRepositoryImpl(private val screenInfoLocalDataStore: ScreenInfoLocalDataStore) :
    InfoRepository<List<ScreenInfo>> {

    override suspend fun getInfo(): LiveData<List<ScreenInfo>> = screenInfoLocalDataStore.getData()
}

