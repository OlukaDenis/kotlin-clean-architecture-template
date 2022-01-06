package com.mcash.client.domain.usecases

import com.mcash.client.core.models.Auth
import com.mcash.client.core.models.hashtags.HashtagEntity
import com.mcash.client.core.models.hashtags.HashtagRequest
import com.mcash.client.core.sealed.Resource
import com.mcash.client.core.utils.Utils.Companion.resolveError
import com.mcash.client.domain.base.BaseSuspendUseCase
import com.mcash.client.domain.dispacher.PiemeDispatcher
import com.mcash.client.domain.repository.PiemateRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.security.InvalidParameterException
import javax.inject.Inject

class TrendingHashtagUseCase @Inject constructor(
    private val repository: PiemateRepository,
    dispatcher: PiemeDispatcher
): BaseSuspendUseCase<TrendingHashtagUseCase.Param, Flow<Resource<List<HashtagEntity>>>>(dispatcher) {

    override suspend fun execute(parameter: Param?): Flow<Resource<List<HashtagEntity>>> = flow {
        try {
            emit(Resource.Loading)
            parameter?.let {
                val auth = Auth(it.id, it.token)
                val request = HashtagRequest(auth, "trending_hashtags")
                val response = repository.fetchTrendingHashtags(request)
                emit(Resource.Success(response))
            }
        } catch (throwable: Throwable) {
            emit(Resource.Error(resolveError(throwable)))
        }

//        return parameter?.let {
//            val auth = Auth(it.id, it.token)
//            val request = HashtagRequest(auth, "trending_hashtags")
//            repository.fetchTrendingHashtags(request)
//        } ?: throw InvalidParameterException()


    }

    data class Param(
        val id: String,
        val token: String
    )
}