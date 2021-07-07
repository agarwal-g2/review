package com.review.hotel

import com.fasterxml.jackson.databind.ObjectMapper
import com.review.hotel.hotelReview.controller.HotelReviewController
import com.review.hotel.hotelReview.model.HotelReview
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.InjectMocks
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.lang.annotation.Inherited



@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.MOCK
)
@AutoConfigureMockMvc
class HotelApplicationTests(
		@Autowired val mvc: MockMvc,
		@Autowired val mapper: ObjectMapper
) {

	@BeforeEach
	fun setup() {
		val hotelReviewController = HotelReviewController
		MockMvcBuilders.standaloneSetup(hotelReviewController).build()
	}

	@Test
	fun create() {

		mvc.perform(MockMvcRequestBuilders.post("/${HotelReviewController.API_HOTEL_REVIEW}")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(
						HotelReview(
								review = "Hotel is great",
								rating = 5,
								hotelId = "0beae827-c860-4003-91c0-b1ac6d021f4c",
								userId = "0sdjs3n3-c860-4003-91c0-b1ac6d021f4c"
						)
				))
				.header("accept", "application/json"))
				.andExpect(MockMvcResultMatchers.status().isCreated)
				.andExpect(MockMvcResultMatchers.jsonPath("$.hotelId").isNotEmpty)
				.andExpect(MockMvcResultMatchers.jsonPath("$.hotelId").value("0beae827-c860-4003-91c0-b1ac6d021f4c"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.userId").isNotEmpty)
				.andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("0sdjs3n3-c860-4003-91c0-b1ac6d021f4c"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty)
	}

	@Test
	fun get() {
		mvc.perform(MockMvcRequestBuilders.get("/${HotelReviewController.API_HOTEL_REVIEW}")
				.contentType(MediaType.APPLICATION_JSON)
				.header("accept", "application/json"))
				.andExpect(MockMvcResultMatchers.status().isOk)
	}
}
