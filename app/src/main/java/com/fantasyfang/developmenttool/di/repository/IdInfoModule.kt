package com.fantasyfang.developmenttool.di.repository

import com.fantasyfang.developmenttool.data.IdInfo
import com.fantasyfang.developmenttool.repository.InfoRepository
import com.fantasyfang.developmenttool.repository.id.IdInfoLocalDataStore
import com.fantasyfang.developmenttool.repository.id.IdInfoRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object IdInfoModule {

    @Provides
    @Singleton
    fun provideIdInfoRepository(idInfoLocalDataStore: IdInfoLocalDataStore): InfoRepository<List<IdInfo>> =
        IdInfoRepositoryImpl(idInfoLocalDataStore)
}