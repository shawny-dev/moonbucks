package io.moonbucks.api.provider

import io.moonbucks.api.dto.member.Exception
import io.moonbucks.api.exception.Unauthorized
import io.moonbucks.api.exception.BadRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(value = [Unauthorized::class])
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    fun handleUnauthorized(req: HttpServletRequest, e: Unauthorized): Exception {
        return Exception(e)
    }

    @ExceptionHandler(value = [BadRequest::class])
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleBadRequest(req: HttpServletRequest, e: BadRequest): Exception {
        return Exception(e)
    }

}
