package repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import base.BasePagingDataSource
import base.BaseRepository
import entity.Entity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import mappers.asEntity
import mappers.asRoomEntity
import models.ResponseStatus
import paging.people.PeoplePagingSource
import room.dao.PeopleDao
import search.people.models.PeopleFullDataEntity
import starWars.api.SearchApi

class PeopleRepositoryImpl(
    private val searchApi: SearchApi,
    private val peopleDao: PeopleDao
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

    override suspend fun savePeople(peopleFullDataEntity: PeopleFullDataEntity) {
        peopleDao.savePeople(
            peopleFullDataEntity.asRoomEntity()
        )
    }

    override suspend fun deletePeople(peopleFullDataEntity: PeopleFullDataEntity) {
        peopleDao.deletePeople(
            peopleFullDataEntity.name
        )
    }

    override fun getAllSavedPeople(): Flow<List<PeopleFullDataEntity>> {
        return peopleDao.getAllSavedPeople().map { peopleEntities ->
            peopleEntities.map { it.asEntity() }
        }
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