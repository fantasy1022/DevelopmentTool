package com.fantasyfang.developmenttool.data

class IdInfo(val item: Item<ScreenItem, String>) : InfoBase {
    override fun getStringId(): Int = item.name.value

    override fun getValue(): String = item.value
}