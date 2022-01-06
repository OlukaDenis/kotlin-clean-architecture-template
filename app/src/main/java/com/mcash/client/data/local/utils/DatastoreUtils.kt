package com.mcash.client.data.local.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.mcash.client.UserPreference
import com.mcash.client.data.local.serializers.UserPreferenceSerializer

val Context.userProtoDataStore: DataStore<UserPreference> by dataStore(
    fileName = LocalConstants.USER_PREF_DB,
    serializer = UserPreferenceSerializer
)