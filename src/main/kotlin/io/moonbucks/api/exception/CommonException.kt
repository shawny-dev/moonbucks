package io.moonbucks.api.exception

abstract class CommonException(
        override val message: String,
        val dialog: String = "client",
) : Exception()