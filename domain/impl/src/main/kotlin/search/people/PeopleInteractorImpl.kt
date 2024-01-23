package search.people

import androidx.paging.PagingData
import entity.Entity
import kotlinx.coroutines.flow.Flow
import repositories.PeopleRepository
import search.people.interactors.PeopleInteractor
import search.people.models.PeopleFullDataEntity

class PeopleInteractorImpl(
    private val peopleRepository: PeopleRepository
): PeopleInteractor  {
    override fun searchPeoplePagingData( search: String ): Flow<PagingData<PeopleFullDataEntity>> {
        return peopleRepository.searchPeople(search)
    }

    override fun getAllSavedPeople(): Flow<List<PeopleFullDataEntity>> {
        return peopleRepository.getAllSavedPeople()
    }

    override suspend fun savePeople(peopleFullDataEntity: PeopleFullDataEntity) {
        return peopleRepository.savePeople(peopleFullDataEntity)
    }

    override suspend fun deletePeople(peopleFullDataEntity: PeopleFullDataEntity) {
        return peopleRepository.deletePeople(peopleFullDataEntity)
    }

    override suspend fun getPeople(name: String): Entity<List<PeopleFullDataEntity>> {
        return peopleRepository.getPeople(name)
    }


}