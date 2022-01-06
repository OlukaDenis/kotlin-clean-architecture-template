package com.mcash.client.data.remote.di

import com.mcash.client.data.remote.services.PiemateService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    @Singleton
    internal fun provideAuthenticationService(
        retrofit: Retrofit
    ): PiemateService {
        return retrofit.create(PiemateService::class.java)
    }
}