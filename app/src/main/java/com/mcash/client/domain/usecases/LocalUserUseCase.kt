package com.mcash.client.domain.usecases

import com.mcash.client.core.models.User
import com.mcash.client.domain.repository.LocalRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class LocalUserUseCase @Inject constructor(
    private val repository: LocalRepository
) {
    suspend fun saveUser(user: User) = repository.saveUserToDatastore(user)

    fun getUser(): User = runBlocking { repository.getDataStoreUser().first() }
}