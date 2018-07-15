package com.joeli.transfer.utils

fun String.isValidAmount(): Boolean {
    return !this.isEmpty() && (this.toIntOrNull()?.let { it > 0 } ?: false)
}