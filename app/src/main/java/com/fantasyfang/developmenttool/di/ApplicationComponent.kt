package com.fantasyfang.developmenttool.di

import com.fantasyfang.developmenttool.MainApplication
import com.fantasyfang.developmenttool.di.repository.DeviceInfoModule
import com.fantasyfang.developmenttool.di.repository.IdInfoModule
import com.fantasyfang.developmenttool.di.repository.ScreenInfoModule
import com.fantasyfang.developmenttool.ui.main.MainActivityModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        MainActivityModule::class,
        ScreenInfoModule::class,
        DeviceInfoModule::class,
        IdInfoModule::class]
)
interface ApplicationComponent : AndroidInjector<MainApplication> {
    @Component.Factory
    interface Factory : AndroidInjector.Factory<MainApplication>
}