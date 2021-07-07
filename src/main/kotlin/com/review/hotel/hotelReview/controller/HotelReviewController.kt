package com.review.hotel.hotelReview.controller

import com.review.hotel.hotelReview.model.HotelReview
import com.review.hotel.hotelReview.model.HotelReviewUpdateDTO
import com.review.hotel.hotelReview.service.HotelReviewService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(produces = ["application/json", "application/xml"])
class HotelReviewController(
        var hotelReviewService: HotelReviewService
) {
    val httpHeaders = HttpHeaders()

    @Operation(
            summary = "Create Hotel Review record",
            method = "POST",
            description = ""
    )
    @PostMapping(API_HOTEL_REVIEW)
    fun create(@RequestBody hotelReview: HotelReview): ResponseEntity<HotelReview> {
        return ResponseEntity(hotelReviewService.create(hotelReview), HttpStatus.CREATED)
    }

    @Operation(
            summary = "Get all review",
            method = "GET",
            description = ""
    )
    @GetMapping(API_HOTEL_REVIEW)
    fun get(): ResponseEntity<MutableList<HotelReview?>> {
        return ResponseEntity(hotelReviewService.get(), HttpStatus.OK)
    }

    @Operation(
            summary = "Get hotel reviews by id",
            method = "GET",
            description = ""
    )
    @GetMapping("$API_HOTEL_REVIEW/{id}")
    fun getById(@PathVariable id: String ): ResponseEntity<HotelReview> {
        return ResponseEntity(hotelReviewService.getById(id), HttpStatus.OK)
    }

    @Operation(
            summary = "Get reviews by hotel id",
            method = "GET",
            description = ""
    )
    @GetMapping("$API_HOTEL_REVIEW/hotel")
    fun getByHotelId(@RequestParam hotelId: String): ResponseEntity<MutableList<HotelReview?>> {
        return ResponseEntity(hotelReviewService.getByHotelId(hotelId), HttpStatus.OK)
    }

    @Operation(
            summary = "Get hotel review by user id",
            method = "GET",
            description = ""
    )
    @GetMapping("$API_HOTEL_REVIEW/user")
    fun getByUserId(@RequestParam userId: String): ResponseEntity<MutableList<HotelReview?>> {
        return ResponseEntity(hotelReviewService.getByHotelId(userId), HttpStatus.OK)
    }

    @Operation(
            summary = "Update hotel review and rating",
            method = "PUT",
            description = ""
    )
    @PutMapping("$API_HOTEL_REVIEW/{id}")
    fun update(@PathVariable id: String , @RequestBody hotelReview: HotelReviewUpdateDTO): ResponseEntity<HotelReview> {
        return ResponseEntity(hotelReviewService.update(id, hotelReview), HttpStatus.OK)
    }

    @Operation(
            summary = "delete review by review id",
            method = "delete",
            description = ""
    )
    @DeleteMapping("$API_HOTEL_REVIEW/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Unit> {
        return ResponseEntity(hotelReviewService.delete(id), HttpStatus.OK)
    }

    companion object {
        const val API_HOTEL_REVIEW = "api/v1/HotelReview"
    }
}