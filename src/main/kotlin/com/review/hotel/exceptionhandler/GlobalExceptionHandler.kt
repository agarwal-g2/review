package com.review.hotel.exceptionhandler


import com.review.hotel.exceptionhandler.validationexceptions.NotFoundException
import org.apache.logging.log4j.LogManager
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {

    companion object {
        val LOGGER = LogManager.getLogger(GlobalExceptionHandler::class.java)
    }


    @ExceptionHandler(Exception::class)
    fun globalException(ex: Exception, request: WebRequest): ResponseEntity<Any>? {
        val errorRef = generateErrorRef()
        LOGGER.warn("errorRef: $errorRef", ex)
        return ResponseEntity(ex.cause?.message ?: ex.message, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(NotFoundException::class)
    fun exceptionForResourceNotFound(ex: NotFoundException, request: WebRequest): ResponseEntity<Any> {
        return ResponseEntity(ex.cause?.message ?: ex.message, HttpStatus.NOT_FOUND)
    }

    private fun generateErrorRef(): String {
        return UUID.randomUUID().toString().substring(0, 6).toUpperCase()
    }
}
