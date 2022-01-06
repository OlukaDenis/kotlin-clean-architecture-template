package com.mcash.client.domain.dispacher

import kotlinx.coroutines.CoroutineDispatcher

interface PiemeDispatcher {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
}