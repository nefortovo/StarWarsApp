package search.people.interactors

import androidx.paging.PagingData
import entity.Entity
import kotlinx.coroutines.flow.Flow
import search.people.models.PeopleFullDataEntity

interface PeopleInteractor {
    fun searchPeoplePagingData(
        search: String
    ) : Flow<PagingData<PeopleFullDataEntity>>

    fun getAllSavedPeople(
    ) : Flow<List<PeopleFullDataEntity>>

    suspend fun savePeople(peopleFullDataEntity: PeopleFullDataEntity)
    suspend fun deletePeople(peopleFullDataEntity: PeopleFullDataEntity)

    suspend fun getPeople(name: String): Entity<List<PeopleFullDataEntity>>

}