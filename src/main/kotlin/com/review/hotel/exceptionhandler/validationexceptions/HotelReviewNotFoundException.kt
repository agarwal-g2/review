package com.review.hotel.exceptionhandler.validationexceptions

import org.springframework.http.HttpStatus

class HotelReviewNotFoundException(message: String) : NotFoundException(message, HttpStatus.NOT_FOUND)