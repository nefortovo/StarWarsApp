package repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import base.BasePagingDataSource
import base.BaseRepository
import kotlinx.coroutines.flow.Flow
import paging.people.PeoplePagingSource
import search.people.models.PeopleFullDataEntity
import starWars.api.SearchApi

class PeopleRepositoryImpl(
    private val searchApi: SearchApi
) : PeopleRepository, BaseRepository(TAG) {
    override fun searchPeople(name: String): Flow<PagingData<PeopleFullDataEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = BasePagingDataSource.LIMIT
            ),
            pagingSourceFactory = {
                PeoplePagingSource(
                    searchApi = searchApi,
                    name = name
                )
            }
        ).flow

    }

    companion object {
        val TAG = PeopleRepositoryImpl::class.toString()
    }
}