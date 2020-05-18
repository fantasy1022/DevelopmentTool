package com.fantasyfang.developmenttool.repository

interface InfoRepository<T> {
    fun getInfo(): T
}