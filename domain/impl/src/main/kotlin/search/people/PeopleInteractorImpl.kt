package search.people

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import repositories.PeopleRepository
import search.people.interactors.PeopleInteractor
import search.people.models.PeopleFullDataEntity

class PeopleInteractorImpl(
    private val peopleRepository: PeopleRepository
): PeopleInteractor  {
    override fun searchPeoplePagingData(name: String): Flow<PagingData<PeopleFullDataEntity>> {
        return peopleRepository.searchPeople(name)
    }
}