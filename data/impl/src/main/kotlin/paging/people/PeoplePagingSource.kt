package paging.people

import android.util.Log
import androidx.paging.PagingState
import base.BasePagingDataSource
import mappers.asEntity
import models.ResponseStatus
import search.people.models.PeopleFullDataEntity
import starWars.api.SearchApi

class PeoplePagingSource(
    private val searchApi: SearchApi,
    private val initCount: Int = LIMIT,
    private val initPage: Int = PAGE,
    private val search: String,
) : BasePagingDataSource<PeopleFullDataEntity>() {

    override fun getRefreshKey(state: PagingState<Int, PeopleFullDataEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PeopleFullDataEntity> {

        val pageNumber = params.key ?: initPage
        val pageSize = params.loadSize.coerceAtMost(initCount)
        val resp = safeApiSuspendResult {
            searchApi.searchPeople(
                page = pageNumber,
                search = search
            )
        }
        Log.d("POMOGITE", "load called. Key: resp")

        when (resp) {
            is ResponseStatus.Success -> {
                resp.data?.let { data ->
                    val nextKey = if (data.results.size < pageSize) null else pageNumber + 1
                    val prevKey = if (pageNumber == 1) null else pageNumber - 1
                    return LoadResult.Page(
                        data = data.results.map { it.asEntity() },
                        nextKey = nextKey,
                        prevKey = prevKey,
                    )
                } ?: run {
                    return LoadResult.Error(NullPointerException("PagingSourceOrdersHistory got null data"))
                }
            }

            is ResponseStatus.Error -> {
                return LoadResult.Error(Exception(resp.exception.message))
            }

            else -> {
                return LoadResult.Error(Exception("ZALUPAPENIS"))
            }
        }
    }
}

