package com.example.starWars.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import room.dao.PeopleDao
import room.database.PeopleDatabase

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    fun providePeopleDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        PeopleDatabase::class.java,
        "people_data_base"
    )
        .build()

    @Provides
    fun provideChannelDao(peopleDatabase: PeopleDatabase): PeopleDao {
        return peopleDatabase.peopleDao()
    }
}