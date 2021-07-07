package com.review.hotel.hotelReview.service

import com.review.hotel.exceptionhandler.validationexceptions.HotelReviewNotFoundException
import com.review.hotel.hotelReview.model.HotelReview
import com.review.hotel.hotelReview.model.HotelReviewUpdateDTO
import com.review.hotel.hotelReview.repository.HotelReviewRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class HotelReviewServiceImpl(
        var hotelReviewRepository: HotelReviewRepository
) : HotelReviewService {

    override fun create(hotelReview: HotelReview): HotelReview {
        hotelReview.id = UUID.randomUUID().toString()
        hotelReview.createdAt = LocalDateTime.now()
        hotelReview.updatedAt = LocalDateTime.now()
        return hotelReviewRepository.save(hotelReview)
    }

    override fun get(): MutableList<HotelReview?> {
        return hotelReviewRepository.findAll()
    }

    override fun getById(reviewId: String): HotelReview {
        return hotelReviewRepository.findByIdOrNull(reviewId) ?: throw HotelReviewNotFoundException("Review Id: $reviewId not found")
    }

    override fun getByHotelId(hotelId: String): MutableList<HotelReview?> {
        return hotelReviewRepository.findByHotelId(hotelId)
    }

    override fun getByUserId(userId: String): MutableList<HotelReview?> {
        return hotelReviewRepository.findByUserId(userId)
    }

    override fun update(reviewId: String, hotelReview: HotelReviewUpdateDTO): HotelReview {
        val oldReview = hotelReviewRepository.findByIdOrNull(reviewId) ?: throw HotelReviewNotFoundException("Review Id: $reviewId not found")
        oldReview.review = hotelReview.review
        oldReview.rating = hotelReview.rating
        oldReview.updatedAt = LocalDateTime.now()
        return hotelReviewRepository.save(oldReview)
    }

    override fun delete(reviewId: String) {
        hotelReviewRepository.findByIdOrNull(reviewId) ?: throw HotelReviewNotFoundException("Review Id: $reviewId not found")
        hotelReviewRepository.deleteById(reviewId)
    }

}