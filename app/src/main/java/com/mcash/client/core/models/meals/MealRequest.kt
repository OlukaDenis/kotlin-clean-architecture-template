package com.mcash.client.core.models.meals

import com.mcash.client.core.models.Auth
import com.mcash.client.core.models.BaseRequest

data class MealRequest(
    val auth: Auth,
    val service: String,
    val request: MealData
): BaseRequest(auth, service)

data class MealData(
    val data: MealRequestData
)

data class MealRequestData(
    var offset: String,
    var sort_by: String,
    var price_range: String,
    var distance: String,
    var category_id: String = "",
    var lat: String? = "",
    var long: String? = "",
    var search_text: String = ""
)