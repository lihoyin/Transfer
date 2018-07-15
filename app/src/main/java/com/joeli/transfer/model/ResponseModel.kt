package com.joeli.transfer.model

object ResponseModel {
    data class Response(val result: Result)
    data class Result(val success: Boolean, val error: Error)
    data class Error(val code: Int, val message: String)
}