package com.mcash.client.data.remote.impl

import com.mcash.client.core.models.hashtags.HashtagEntity
import com.mcash.client.core.models.hashtags.HashtagRequest
import com.mcash.client.data.remote.services.PiemateService
import com.mcash.client.domain.repository.PiemateRepository
import javax.inject.Inject

class PiemateRepositoryImpl @Inject constructor(
    private val service: PiemateService
): PiemateRepository {

    override suspend fun fetchTrendingHashtags(request: HashtagRequest): List<HashtagEntity> {
        return try {
            service.fetchTrendingHashtags(request)
        } catch (throwable: Throwable) {
            throw throwable
        }
    }
}