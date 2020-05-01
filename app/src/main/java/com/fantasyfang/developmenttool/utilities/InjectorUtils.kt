package com.fantasyfang.developmenttool.utilities

import android.content.Context
import com.fantasyfang.developmenttool.repository.screen.ScreenInfoLocalDataStore
import com.fantasyfang.developmenttool.repository.screen.ScreenInfoRepository
import com.fantasyfang.developmenttool.repository.screen.ScreenInfoRepositoryImpl
import com.fantasyfang.developmenttool.ui.screen.ScreenInfoViewModelFactory

/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 * TODO: Use Dagger
 */
object InjectorUtils {

    private fun getScreenInfoLocalDataStore(context: Context): ScreenInfoLocalDataStore =
        ScreenInfoLocalDataStore(context)

    private fun getScreenInfoRepository(context: Context): ScreenInfoRepository =
        ScreenInfoRepositoryImpl(getScreenInfoLocalDataStore(context))

    fun getScreenInfoViewModelFactory(context: Context): ScreenInfoViewModelFactory {
        return ScreenInfoViewModelFactory(getScreenInfoRepository(context))
    }

}