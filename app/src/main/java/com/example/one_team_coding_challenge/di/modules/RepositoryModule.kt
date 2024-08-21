package com.example.one_team_coding_challenge.di.modules

import com.example.one_team_coding_challenge.repository.TemperRepository
import com.example.one_team_coding_challenge.repository.TemperRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideTemperRepository(repositoryImpl: TemperRepositoryImpl): TemperRepository
}