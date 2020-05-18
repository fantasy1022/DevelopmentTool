package com.fantasyfang.developmenttool.di.repository

import com.fantasyfang.developmenttool.repository.device.DeviceInfoLocalDataStore
import com.fantasyfang.developmenttool.repository.device.DeviceInfoRepository
import com.fantasyfang.developmenttool.repository.device.DeviceInfoRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DeviceInfoModule {

    @Provides
    @Singleton
    fun provideDeviceInfoRepository(deviceInfoLocalDataStore: DeviceInfoLocalDataStore): DeviceInfoRepository =
        DeviceInfoRepositoryImpl(deviceInfoLocalDataStore)
}