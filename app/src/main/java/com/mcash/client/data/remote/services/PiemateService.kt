package com.mcash.client.data.remote.services

import com.mcash.client.core.models.events.EventRequest
import com.mcash.client.core.models.events.EventResponse
import com.mcash.client.core.models.hashtags.HashtagEntity
import com.mcash.client.core.models.hashtags.HashtagRequest
import com.mcash.client.core.models.meals.MealRequest
import com.mcash.client.core.models.meals.MealResponse
import com.mcash.client.core.models.profiles.PiemateRequest
import com.mcash.client.core.models.profiles.PiemateResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface PiemateService {

    @POST("service")
    suspend fun getPiemates(
        @Body request: PiemateRequest
    ): PiemateResponse

    @POST("service")
    suspend fun fetchTrendingMeals(
        @Body request: MealRequest
    ): MealResponse

    @POST("service")
    suspend fun fetchTrendingEvents(
        @Body request: EventRequest
    ): EventResponse

    @POST("service")
    suspend fun fetchTrendingHashtags(
        @Body request: HashtagRequest
    ): List<HashtagEntity>
}