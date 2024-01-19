package search.people.interactors

import androidx.paging.PagingData
import entity.Entity
import kotlinx.coroutines.flow.Flow
import search.people.models.PeopleFullDataEntity

interface PeopleInteractor {
    fun searchPeoplePagingData(
        search: String
    ) : Flow<PagingData<PeopleFullDataEntity>>

    suspend fun getPeople(name: String): Entity<List<PeopleFullDataEntity>>

}