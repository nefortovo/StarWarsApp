package room.entities.people

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import room.entities.people.PeopleEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME,
    indices = [Index(value = ["name"],
        unique = true)])
data class PeopleEntity (
    @PrimaryKey
    val peopleId: Long? = null,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo("height")
    val height: String,
    @ColumnInfo("mass")
    val mass: String,
    @ColumnInfo("hair_color")
    val hairColor: String,
    @ColumnInfo("skin_color")
    val skinColor: String,
    @ColumnInfo("eye_color")
    val eyeColor: String,
    @ColumnInfo("birth_year")
    val birthYear: String,
    @ColumnInfo("gender")
    val gender: String,
    @ColumnInfo("homeworld")
    val homeworld: String,
    @ColumnInfo("films")
    val films: String,
    @ColumnInfo("species")
    val species: String,
    @ColumnInfo("vehicles")
    val vehicles: String,
    @ColumnInfo("starships")
    val starships: String,
    @ColumnInfo("isFavorite")
    val isFavorite: Boolean,
){
    companion object{
        const val TABLE_NAME = "people_table"
    }
}