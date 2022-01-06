package com.mcash.client.domain.repository

import com.mcash.client.UserPreference
import com.mcash.client.core.models.User
import kotlinx.coroutines.flow.Flow

interface LocalRepository {

    suspend fun saveUserToDatastore(user: User)

    suspend fun getDataStoreUser(): Flow<User>
}