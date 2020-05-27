package com.fantasyfang.developmenttool.ui.main

import com.fantasyfang.developmenttool.di.ActivityScope
import com.fantasyfang.developmenttool.di.FragmentScope
import com.fantasyfang.developmenttool.ui.device.DeviceInfoFragment
import com.fantasyfang.developmenttool.ui.device.DeviceInfoFragmentModule
import com.fantasyfang.developmenttool.ui.id.IdInfoFragment
import com.fantasyfang.developmenttool.ui.id.IdInfoFragmentModule
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

    @FragmentScope
    @ContributesAndroidInjector(modules = [DeviceInfoFragmentModule::class])
    abstract fun contributeDeviceInfoFragment(): DeviceInfoFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [IdInfoFragmentModule::class])
    abstract fun contributeIdInfoFragment(): IdInfoFragment
}