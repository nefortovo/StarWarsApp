package com.example.starWars.di

import com.example.starWars.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import provider.NetworkProvider
import starWars.api.SearchApi
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class BackendStarWars

@Module
@InstallIn(SingletonComponent::class)
class ApiNetworkModule {

    @Provides
    @BackendStarWars
    fun provideUrlBackendChallengeHack(): String = BuildConfig.STARWARS_BACKEND


    @Provides
    fun provideNetworkProvider(
        @BackendStarWars host: String,
    ): NetworkProvider = NetworkProvider(
        host,
    )

    @Provides
    fun provideSearchApi(
        provider: NetworkProvider,
    ): SearchApi = provider.provideRetrofit(SearchApi::class.java)

//    @Provides
//    fun provideRoomApi(
//        provider: NetworkProvider,
//    ): RoomApi = provider.provideRetrofit(RoomApi::class.java)
//
//    @Provides
//    fun provideProfileApi(
//        provider: NetworkProvider,
//    ): ProfileApi = provider.provideRetrofit(ProfileApi::class.java)
//
//    @Provides
//    fun provideTrackApi(
//        provider: NetworkProvider,
//
//    )
}