package com.fantasyfang.developmenttool.repository

import androidx.lifecycle.LiveData

interface LocalDataStore<T> {
    suspend fun getData(): LiveData<T>
}