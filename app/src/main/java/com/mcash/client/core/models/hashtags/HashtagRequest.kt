package com.mcash.client.core.models.hashtags

import com.mcash.client.core.models.Auth
import com.mcash.client.core.models.BaseRequest

class HashtagRequest(
    private val auth: Auth,
    private val service: String
): BaseRequest(auth, service)