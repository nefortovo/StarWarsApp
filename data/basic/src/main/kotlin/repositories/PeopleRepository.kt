package repositories

import androidx.paging.PagingData
import entity.Entity
import kotlinx.coroutines.flow.Flow
import search.people.models.PeopleFullDataEntity

interface PeopleRepository {
    fun searchPeople(
        search: String
    ) : Flow<PagingData<PeopleFullDataEntity>>

    suspend fun savePeople(peopleFullDataEntity: PeopleFullDataEntity)
    suspend fun deletePeople(peopleFullDataEntity: PeopleFullDataEntity)
    fun getAllSavedPeople() : Flow<List<PeopleFullDataEntity>>
    suspend fun getPeople(name: String): Entity<List<PeopleFullDataEntity>>

}