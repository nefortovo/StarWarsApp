package search.people.interactors

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import search.people.models.PeopleFullDataEntity

interface PeopleInteractor {
    fun searchPeoplePagingData(name: String) : Flow<PagingData<PeopleFullDataEntity>>
}