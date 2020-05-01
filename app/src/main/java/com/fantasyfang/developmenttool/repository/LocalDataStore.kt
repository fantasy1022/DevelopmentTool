package com.fantasyfang.developmenttool.repository

interface LocalDataStore<T> {
    fun getData(): T
}