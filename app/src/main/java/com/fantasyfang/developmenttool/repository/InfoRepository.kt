package com.fantasyfang.developmenttool.repository

import androidx.lifecycle.LiveData

interface InfoRepository<T> {
    suspend fun getInfo(): LiveData<T>
}