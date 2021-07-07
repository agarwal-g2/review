package com.review.hotel.hotelReview.repository

import com.review.hotel.hotelReview.model.HotelReview
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface HotelReviewRepository : JpaRepository<HotelReview?, String?> {

    fun findByHotelId(id: String): MutableList<HotelReview?>

    fun findByUserId(id: String): MutableList<HotelReview?>
}