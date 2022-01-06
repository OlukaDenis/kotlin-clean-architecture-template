package com.mcash.client.domain.repository

import com.mcash.client.core.models.events.EventEntity
import com.mcash.client.core.models.events.EventRequest
import com.mcash.client.core.models.hashtags.HashtagEntity
import com.mcash.client.core.models.hashtags.HashtagRequest
import com.mcash.client.core.models.meals.MealEntity
import com.mcash.client.core.models.meals.MealRequest
import com.mcash.client.core.models.profiles.PiemateModelEntity
import com.mcash.client.core.models.profiles.PiemateRequest
import com.mcash.client.core.sealed.Resource

interface PiemateRepository {
    suspend fun fetchTrendingHashtags(request: HashtagRequest): List<HashtagEntity>
}