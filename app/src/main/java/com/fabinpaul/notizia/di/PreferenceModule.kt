package com.fabinpaul.notizia.di

import com.fabinpaul.notizia.preference.UserPreference
import com.fabinpaul.notizia.preference.UserPreferenceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object PreferenceModule {

    @Provides
    fun provideUserPreference(): UserPreference {
        return UserPreferenceImpl
    }
}