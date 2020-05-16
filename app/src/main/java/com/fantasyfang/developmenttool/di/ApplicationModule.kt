package com.fantasyfang.developmenttool.di

import android.content.Context
import com.fantasyfang.developmenttool.MainApplication
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ApplicationModule {
    @Singleton
    @Binds
    abstract fun provideContext(app: MainApplication): Context
}