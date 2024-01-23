package room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import room.entities.people.PeopleEntity

@Dao
interface PeopleDao {
    @Upsert
    suspend fun savePeople(peopleEntity: PeopleEntity)

    @Query("DELETE FROM ${PeopleEntity.TABLE_NAME} WHERE name = :name")
    suspend fun deletePeople(name: String)

    @Query("SELECT * FROM ${PeopleEntity.TABLE_NAME}")
    fun getAllSavedPeople(): Flow<List<PeopleEntity>>
}