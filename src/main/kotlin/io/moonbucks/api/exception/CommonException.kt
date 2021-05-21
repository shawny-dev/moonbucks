package io.moonbucks.api.exception

abstract class CommonException(
        override val message: String,
        val dialog: String = "client",
) : Exception()

class BadRequest : CommonException(message = "잘못된 요청입니다.")
