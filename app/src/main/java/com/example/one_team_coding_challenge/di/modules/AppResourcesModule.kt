package com.example.one_team_coding_challenge.di.modules

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppResourcesModule {
    @Singleton
    @Provides
    fun provideAppResources(@ApplicationContext context: Context): Resources = context.resources
}