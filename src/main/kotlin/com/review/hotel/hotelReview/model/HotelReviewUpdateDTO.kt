package com.review.hotel.hotelReview.model

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Id

class HotelReviewUpdateDTO (
        var review: String,
        var rating: Int
)