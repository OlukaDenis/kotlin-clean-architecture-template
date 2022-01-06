package com.mcash.client.core.models.profiles

import com.mcash.client.core.models.BaseResponse

data class PiemateResponse(
    private val lang: String,
    private val success: Int,
    private val message: String,
    private val count: Int,
    private val offset: Int,
    val data: List<PiemateModelEntity>
): BaseResponse(lang, success, message, count, offset)
