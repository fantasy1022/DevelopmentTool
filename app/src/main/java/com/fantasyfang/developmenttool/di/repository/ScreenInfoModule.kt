package com.fantasyfang.developmenttool.di.repository

import com.fantasyfang.developmenttool.data.ScreenUIInfo
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
    fun provideScreenInfoRepository(screenInfoLocalDataStore: ScreenInfoLocalDataStore): InfoRepository<ScreenUIInfo> =
        ScreenInfoRepositoryImpl(screenInfoLocalDataStore)
}