package com.fantasyfang.developmenttool.utilities

import com.fantasyfang.developmenttool.repository.device.DeviceInfoLocalDataStore
import com.fantasyfang.developmenttool.repository.device.DeviceInfoRepository
import com.fantasyfang.developmenttool.repository.device.DeviceInfoRepositoryImpl
import com.fantasyfang.developmenttool.ui.device.DeviceInfoViewModelFactory

/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 * TODO: Use Dagger
 */
object InjectorUtils {

    //Device
    private fun getDeviceInfoLocalDataStore(): DeviceInfoLocalDataStore =
        DeviceInfoLocalDataStore()

    private fun getDeviceInfoRepository(): DeviceInfoRepository =
        DeviceInfoRepositoryImpl(getDeviceInfoLocalDataStore())

    fun getDeviceInfoViewModelFactory(): DeviceInfoViewModelFactory {
        return DeviceInfoViewModelFactory(getDeviceInfoRepository())
    }

}