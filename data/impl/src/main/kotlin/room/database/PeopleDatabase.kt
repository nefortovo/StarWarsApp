package room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import room.dao.PeopleDao
import room.entities.people.PeopleEntity

@Database(
    entities = [PeopleEntity::class],
    version = 6,
    exportSchema = true
)
abstract class PeopleDatabase : RoomDatabase() {
    abstract fun peopleDao() : PeopleDao
}