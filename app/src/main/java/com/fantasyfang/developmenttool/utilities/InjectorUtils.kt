package com.fantasyfang.developmenttool.utilities

import android.content.Context
import com.fantasyfang.developmenttool.repository.device.DeviceInfoLocalDataStore
import com.fantasyfang.developmenttool.repository.device.DeviceInfoRepository
import com.fantasyfang.developmenttool.repository.device.DeviceInfoRepositoryImpl
import com.fantasyfang.developmenttool.repository.screen.ScreenInfoLocalDataStore
import com.fantasyfang.developmenttool.repository.screen.ScreenInfoRepository
import com.fantasyfang.developmenttool.repository.screen.ScreenInfoRepositoryImpl
import com.fantasyfang.developmenttool.ui.device.DeviceInfoViewModelFactory
import com.fantasyfang.developmenttool.ui.screen.ScreenInfoViewModelFactory

/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 * TODO: Use Dagger
 */
object InjectorUtils {

    //Screen
    private fun getScreenInfoLocalDataStore(context: Context): ScreenInfoLocalDataStore =
        ScreenInfoLocalDataStore(context)

    private fun getScreenInfoRepository(context: Context): ScreenInfoRepository =
        ScreenInfoRepositoryImpl(getScreenInfoLocalDataStore(context))

    fun getScreenInfoViewModelFactory(context: Context): ScreenInfoViewModelFactory {
        return ScreenInfoViewModelFactory(getScreenInfoRepository(context))
    }

    //Device
    private fun getDeviceInfoLocalDataStore(): DeviceInfoLocalDataStore =
        DeviceInfoLocalDataStore()

    private fun getDeviceInfoRepository(): DeviceInfoRepository =
        DeviceInfoRepositoryImpl(getDeviceInfoLocalDataStore())

    fun getDeviceInfoViewModelFactory(): DeviceInfoViewModelFactory {
        return DeviceInfoViewModelFactory(getDeviceInfoRepository())
    }

}