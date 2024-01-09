package com.example.starWars.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import repositories.PeopleRepository
import repositories.PeopleRepositoryImpl
import starWars.api.SearchApi

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideAuthRepository(
        searchApi: SearchApi,
    ): PeopleRepository {
        return PeopleRepositoryImpl(
            searchApi = searchApi,
        )
    }
}
