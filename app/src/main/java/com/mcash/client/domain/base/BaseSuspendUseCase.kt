package com.mcash.client.domain.base

import com.mcash.client.domain.dispacher.PiemeDispatcher
import kotlinx.coroutines.withContext

/**
 * A base util class that is invoked runs on the IO thread asynchronously
 * Returns a coroutine suspend function
 */
abstract class BaseSuspendUseCase<in Param, Result>(
    private val dispatcher: PiemeDispatcher
) where Param : Any {

    @Throws(RuntimeException::class)
    internal abstract suspend fun execute(parameter: Param? = null): Result

    suspend operator fun invoke(parameter: Param? = null): Result =
        withContext(dispatcher.io) { execute(parameter) }
}