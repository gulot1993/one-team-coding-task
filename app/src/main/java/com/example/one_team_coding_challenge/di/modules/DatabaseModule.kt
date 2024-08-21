package com.example.one_team_coding_challenge.di.modules

import android.app.Application
import android.content.Context
import com.example.one_team_coding_challenge.database.AppDatabase
import com.example.one_team_coding_challenge.database.dao.TemperDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase = AppDatabase.getInstance(context)

    @Provides
    @Singleton
    fun provideTemperDao(appDatabase: AppDatabase): TemperDao = appDatabase.temperDao()

}