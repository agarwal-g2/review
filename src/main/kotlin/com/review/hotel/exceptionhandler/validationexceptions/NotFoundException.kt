package com.review.hotel.exceptionhandler.validationexceptions

import org.springframework.http.HttpStatus

abstract class NotFoundException(message: String, val httpStatus: HttpStatus) : RuntimeException(message)
