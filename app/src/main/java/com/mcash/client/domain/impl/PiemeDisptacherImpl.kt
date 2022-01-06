package com.mcash.client.domain.impl

import com.mcash.client.domain.dispacher.PiemeDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class PiemeDisptacherImpl @Inject constructor() : PiemeDispatcher {
    override val io: CoroutineDispatcher get() = Dispatchers.IO
    override val main: CoroutineDispatcher get() = Dispatchers.Main
}