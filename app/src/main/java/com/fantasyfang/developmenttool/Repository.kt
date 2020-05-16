package com.fantasyfang.developmenttool

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
//For test
class Repository @Inject constructor() {
    fun getMessage() = "From Repository"
}