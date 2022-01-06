package com.mcash.client.core.sealed

import com.mcash.client.core.models.events.EventEntity
import com.mcash.client.core.models.hashtags.HashtagEntity
import com.mcash.client.core.models.meals.MealEntity
import com.mcash.client.core.models.profiles.PiemateModelEntity

sealed class PiemateState {
    object Loading : PiemateState()
    data class Success(val data: List<PiemateModelEntity>) : PiemateState()
    data class Error(val message: String) : PiemateState()
}

sealed class TrendingMealState {
    object Loading : TrendingMealState()
    data class Success(val data: List<MealEntity>) : TrendingMealState()
    data class Error(val message: String) : TrendingMealState()
}

sealed class TrendingEventState {
    object Loading : TrendingEventState()
    data class Success(val data: List<EventEntity>) : TrendingEventState()
    data class Error(val message: String) : TrendingEventState()
}

sealed class TrendingHashtagState {
    object Loading : TrendingHashtagState()
    data class Success(val data: List<HashtagEntity>) : TrendingHashtagState()
    data class Error(val message: String) : TrendingHashtagState()
}