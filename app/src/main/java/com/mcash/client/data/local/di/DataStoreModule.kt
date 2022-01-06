package com.mcash.client.data.local.di

import android.content.Context
import androidx.datastore.core.DataStore
import com.mcash.client.UserPreference
import com.mcash.client.data.local.utils.userProtoDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    internal fun provideUSerPreferenceDatastore(
        @ApplicationContext context: Context
    ): DataStore<UserPreference> = context.userProtoDataStore

}