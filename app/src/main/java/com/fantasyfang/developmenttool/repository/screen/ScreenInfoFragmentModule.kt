package com.fantasyfang.developmenttool.repository.screen

import androidx.fragment.app.Fragment
import com.fantasyfang.developmenttool.di.FragmentScope
import com.fantasyfang.developmenttool.ui.screen.ScreenInfoFragment
import dagger.Binds
import dagger.Module


@Module
abstract class ScreenInfoFragmentModule {

    @Binds
    @FragmentScope
    abstract fun fragment(screenInfoFragment: ScreenInfoFragment): Fragment
}