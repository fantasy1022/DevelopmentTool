package com.fantasyfang.developmenttool.ui.main

import com.fantasyfang.developmenttool.di.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): MainActivity
}