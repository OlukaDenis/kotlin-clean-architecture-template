package com.mcash.client.data.remote.di

import android.content.Context
import com.mcash.client.BuildConfig
import com.mcash.client.data.util.RemoteConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class OkhttpModule {
    @Provides
    @Singleton
    internal fun provideFile(@ApplicationContext context: Context): File {
        return File(context.cacheDir, "pieme_dir")
    }

    @Provides
    @Singleton
    internal fun provideCache(file: File): Cache {
        return Cache(file, RemoteConstants.CACHE_FILE_SIZE)
    }

    @Provides
    @Singleton
    fun provideLogger(): HttpLoggingInterceptor.Logger {
        return HttpLoggingInterceptor.Logger { message -> Timber.i(message) }
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(
        logger: HttpLoggingInterceptor.Logger
    ): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(logger).apply {
            level = when (BuildConfig.BUILD_TYPE) {
                "debug" -> HttpLoggingInterceptor.Level.BODY
                else -> HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    @Provides
    @Singleton
    internal fun provideOkhttpClient(
        cache: Cache,
        interceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.apply {
            connectTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
            cache(cache)
            addInterceptor(interceptor)
        }
        return builder.build()
    }

}