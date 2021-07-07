package com.review.hotel.hotelReview.model

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "hotel_review")
class HotelReview (
        @Id
        @Column(name="id", nullable = false, updatable = false)
        var id: String? = null,

        @Column(name="hotel_id", nullable = false)
        var hotelId: String? = null,

        @Column(name="user_id", nullable = false)
        var userId: String? = null,

        @Column(name="review_id", nullable = false)
        var review: String,

        @Column(name="rating_id", nullable = false)
        var rating: Int,

        @Column(name="created_at", nullable = false)
        var createdAt: LocalDateTime? = null,

        @Column(name="updated_at", nullable = false)
        var updatedAt: LocalDateTime? = null
)