package io.moonbucks.api.dto.member

import io.moonbucks.api.exception.CommonException


class Exception(e: CommonException) {
    class Error(e: CommonException) {
        val name = "V1::Exceptions::${e::class.simpleName}"
        val message = e.message
        val dialog = e.dialog
    }

    val error = Error(e)
}
