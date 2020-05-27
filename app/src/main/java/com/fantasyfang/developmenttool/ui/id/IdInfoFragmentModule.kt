package com.fantasyfang.developmenttool.ui.id

import androidx.fragment.app.Fragment
import com.fantasyfang.developmenttool.di.FragmentScope
import dagger.Binds
import dagger.Module

@Module
abstract class IdInfoFragmentModule {

    @Binds
    @FragmentScope
    abstract fun fragment(idInfoFragment: IdInfoFragment): Fragment
}