package com.fantasyfang.developmenttool.ui.main

import com.fantasyfang.developmenttool.di.ActivityScope
import com.fantasyfang.developmenttool.di.FragmentScope
import com.fantasyfang.developmenttool.ui.screen.ScreenInfoFragment
import com.fantasyfang.developmenttool.ui.screen.ScreenInfoFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): MainActivity

    @FragmentScope
    @ContributesAndroidInjector(modules = [ScreenInfoFragmentModule::class])
    abstract fun contributeScreenInfoFragment(): ScreenInfoFragment
}