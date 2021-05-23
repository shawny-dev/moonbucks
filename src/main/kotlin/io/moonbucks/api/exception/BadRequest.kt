package io.moonbucks.api.exception

abstract class BadRequest(message: String) : CommonException(message = message)

class NotFoundRecordException : BadRequest(message = "Record not found.")
