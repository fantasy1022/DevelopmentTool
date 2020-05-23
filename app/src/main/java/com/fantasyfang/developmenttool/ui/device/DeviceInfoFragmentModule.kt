package com.fantasyfang.developmenttool.ui.device

import androidx.fragment.app.Fragment
import com.fantasyfang.developmenttool.di.FragmentScope
import dagger.Binds
import dagger.Module

@Module
abstract class DeviceInfoFragmentModule {

    @Binds
    @FragmentScope
    abstract fun fragment(deviceInfoFragment: DeviceInfoFragment): Fragment
}