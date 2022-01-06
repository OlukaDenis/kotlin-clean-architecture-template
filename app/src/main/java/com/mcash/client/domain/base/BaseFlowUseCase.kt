package com.mcash.client.domain.base

import com.mcash.client.domain.dispacher.PiemeDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseFlowUseCase<in Param, Result>(
    private val dispatcher: PiemeDispatcher
) where Param : Any {

    abstract fun build(parameter: Param?): Flow<Result>

    fun execute(parameter: Param? = null) =
        build(parameter).flowOn(dispatcher.io)
}