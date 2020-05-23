package com.fantasyfang.developmenttool.di.repository

import com.fantasyfang.developmenttool.data.ScreenInfo
import com.fantasyfang.developmenttool.repository.InfoRepository
import com.fantasyfang.developmenttool.repository.screen.ScreenInfoLocalDataStore
import com.fantasyfang.developmenttool.repository.screen.ScreenInfoRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object ScreenInfoModule {

    @Provides
    @Singleton
    fun provideScreenInfoRepository(screenInfoLocalDataStore: ScreenInfoLocalDataStore): InfoRepository<List<ScreenInfo>> =
        ScreenInfoRepositoryImpl(screenInfoLocalDataStore)
}