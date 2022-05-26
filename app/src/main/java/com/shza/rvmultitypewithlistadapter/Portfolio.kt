package com.shza.rvmultitypewithlistadapter

sealed class Portfolio{

    val id: String = ""

    class Add(
        val name: String
    ): Portfolio()

    class Image(
        val name: String
    ): Portfolio()
}
