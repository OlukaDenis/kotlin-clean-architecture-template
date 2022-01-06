package com.mcash.client.core.models.meals

import com.mcash.client.core.models.BaseResponse

data class MealResponse(
    private val lang: String,
    private val success: Int,
    private val message: String,
    private val count: Int,
    private val offset: Int,
    val data: List<MealEntity>
) : BaseResponse(lang, success, message, count, offset)