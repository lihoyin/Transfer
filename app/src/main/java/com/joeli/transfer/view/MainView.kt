package com.joeli.transfer.view

interface MainView {
    fun onAmountChanged(s: CharSequence, start: Int, before: Int, count: Int)

    fun onSubmit()

    fun onReset()

    fun getAmount(): Int
}