package com.fabinpaul.notizia.di

import com.fabinpaul.notizia.data.source.remote.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideNewsApiService(): NewsApiService {
        return NewsApiService.create()
    }
}