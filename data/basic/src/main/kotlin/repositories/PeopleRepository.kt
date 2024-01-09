package repositories

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import search.people.models.PeopleFullDataEntity

interface PeopleRepository {
    fun searchPeople(
        name: String
    ) : Flow<PagingData<PeopleFullDataEntity>>
}