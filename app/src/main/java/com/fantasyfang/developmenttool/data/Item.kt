package com.fantasyfang.developmenttool.data

import com.fantasyfang.developmenttool.repository.Result

data class Item<T, P>(val name: T, val value: P)

interface InfoBase {
    fun getStringId(): Int
    fun getValue(): Result
}