package com.review.hotel.hotelReview.service

import com.review.hotel.hotelReview.model.HotelReview
import com.review.hotel.hotelReview.model.HotelReviewUpdateDTO

interface HotelReviewService {

    fun create(hotelReview: HotelReview): HotelReview

    fun get(): MutableList<HotelReview?>

    fun getById(reviewId: String): HotelReview

    fun getByHotelId(hotelId: String): MutableList<HotelReview?>

    fun getByUserId(userId: String): MutableList<HotelReview?>

    fun update(reviewId: String, hotelReview: HotelReviewUpdateDTO): HotelReview

    fun delete(reviewId: String)
}