package com.mcash.client.data.local.impl

import androidx.datastore.core.DataStore
import com.mcash.client.UserPreference
import com.mcash.client.core.models.User
import com.mcash.client.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val userPrefDatastore: DataStore<UserPreference>
) : LocalRepository {

    override suspend fun saveUserToDatastore(user: User) {
        userPrefDatastore.updateData { currentUserData ->
            currentUserData.toBuilder()
                .setFirstName(user.firstName)
                .setLastName(user.lastName)
                .setBirthDay(user.birthday)
                .build()
        }
    }

    override suspend fun getDataStoreUser(): Flow<User> {
        saveUserToDatastore(User("Denis", "Oluka", 90))

        return userPrefDatastore.data.map { user ->
            User(
                firstName = user.firstName,
                lastName = user.lastName,
                birthday = user.birthDay
            )
        }
    }
}