package io.moonbucks.api.provider

import io.moonbucks.api.exception.Unauthorized
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
    fun handle(req: HttpServletRequest, e: Unauthorized): Exception {
        return Exception(e)
    }

}
