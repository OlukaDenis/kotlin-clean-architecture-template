package com.mcash.client.core.models.profiles

import com.mcash.client.core.models.Auth
import com.mcash.client.core.models.BaseRequest

data class PiemateRequest(
    val auth: Auth,
    val service: String,
): BaseRequest(auth, service)
