package com.fantasyfang.developmenttool.di

import android.content.Context
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
    fun provideScreenInfoLocalStore(context: Context): ScreenInfoLocalDataStore // LocalDataStore<ScreenUIInfo>
            = ScreenInfoLocalDataStore(context)

    @Provides
    @Singleton
    fun provideScreenInfoRepository(screenInfoLocalDataStore: ScreenInfoLocalDataStore): ScreenInfoRepository =
        ScreenInfoRepositoryImpl(screenInfoLocalDataStore)
}