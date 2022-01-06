package com.mcash.client.data.di

import com.mcash.client.data.local.impl.LocalRepositoryImpl
import com.mcash.client.data.remote.impl.PiemateRepositoryImpl
import com.mcash.client.domain.repository.LocalRepository
import com.mcash.client.domain.repository.PiemateRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindRepository(impl: PiemateRepositoryImpl): PiemateRepository

    @Singleton
    @Binds
    fun bindLocalRepository(impl: LocalRepositoryImpl): LocalRepository
}