package com.example.starWars.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import repositories.PeopleRepository
import search.people.PeopleInteractorImpl
import search.people.interactors.PeopleInteractor

@Module
@InstallIn(SingletonComponent::class)
class InteractorsModule {
    @Provides
    fun providePeopleInteractor(
        peopleRepository: PeopleRepository
    ): PeopleInteractor {
        return PeopleInteractorImpl(
            peopleRepository = peopleRepository
        )
    }
}