package com.mcash.client.core.models.events

import com.mcash.client.core.models.BaseResponse

data class EventResponse(
    val data: List<EventEntity>,
    val lang: String,
    val message: String,
    val offset: Int,
    val count: Int,
    val success: Int,
): BaseResponse(lang, success, message, count, offset)