package com.fantasyfang.developmenttool.di

import com.fantasyfang.developmenttool.repository.screen.ScreenInfoLocalDataStore
import com.fantasyfang.developmenttool.repository.screen.ScreenInfoRepository
import com.fantasyfang.developmenttool.repository.screen.ScreenInfoRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object ScreenInfoModule {

    @Provides
    @Singleton
    fun provideScreenInfoRepository(screenInfoLocalDataStore: ScreenInfoLocalDataStore): ScreenInfoRepository =
        ScreenInfoRepositoryImpl(screenInfoLocalDataStore)
}