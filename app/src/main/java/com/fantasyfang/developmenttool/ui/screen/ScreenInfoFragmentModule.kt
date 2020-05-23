package com.fantasyfang.developmenttool.ui.screen

import androidx.fragment.app.Fragment
import com.fantasyfang.developmenttool.di.FragmentScope
import dagger.Binds
import dagger.Module


@Module
abstract class ScreenInfoFragmentModule {

    @Binds
    @FragmentScope
    abstract fun fragment(screenInfoFragment: ScreenInfoFragment): Fragment
}