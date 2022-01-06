package com.mcash.client.core.models.events

import com.mcash.client.core.models.Auth
import com.mcash.client.core.models.BaseRequest

class EventRequest(
    private val auth: Auth,
    private val service: String,
    private val request: EventData
): BaseRequest(auth, service)

data class EventData(
    val data: EventRequestData
)

data class EventRequestData(
    var offset: String,
    var sort_by: String,
    var price_type: String,
    var distance: String,
    var lat: String? = "",
    var long: String? = "",
    var search_text: String = "",
    var event_type: String = ""
)