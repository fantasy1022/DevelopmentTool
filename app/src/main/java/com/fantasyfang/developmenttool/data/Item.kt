package com.fantasyfang.developmenttool.data

data class Item<T, P>(val name: T, val value: P)

interface InfoBase {
    fun getStringId(): Int
    fun getValue(): String
}