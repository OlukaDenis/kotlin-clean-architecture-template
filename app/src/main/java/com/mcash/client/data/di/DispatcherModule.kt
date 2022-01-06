package com.mcash.client.data.di

import com.mcash.client.domain.dispacher.PiemeDispatcher
import com.mcash.client.domain.impl.PiemeDisptacherImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatcherModule {

    @Binds
    @Singleton
    internal abstract fun bindDispatcher(impl: PiemeDisptacherImpl): PiemeDispatcher
}