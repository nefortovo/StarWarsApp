package repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import base.BasePagingDataSource
import base.BaseRepository
import entity.Entity
import kotlinx.coroutines.flow.Flow
import mappers.asEntity
import models.ResponseStatus
import paging.people.PeoplePagingSource
import search.people.models.PeopleFullDataEntity
import starWars.api.SearchApi

class PeopleRepositoryImpl(
    private val searchApi: SearchApi
) : PeopleRepository, BaseRepository(TAG) {
    override fun searchPeople(search: String): Flow<PagingData<PeopleFullDataEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = BasePagingDataSource.LIMIT,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {
                PeoplePagingSource(
                    searchApi = searchApi,
                    search = search
                )
            }
        ).flow

    }

    override suspend fun getPeople(name: String): Entity<List<PeopleFullDataEntity>> {
        return when (val response = safeApiSuspendResult {
            searchApi.getPeople(name)
        }) {
            is ResponseStatus.Success -> {
                response.data?.let {
                    map {
                        it.results.map { it.asEntity() }
                    }
                } ?: kotlin.run {
                    Entity.Error(
                        "Ошибка парсинга информации пользователя"
                    )
                }
            }

            is ResponseStatus.Error -> {
                Entity.Error(
                    response.exception.message ?: ""
                )
            }
        }
    }


    companion object {
        val TAG = PeopleRepositoryImpl::class.toString()
    }
}