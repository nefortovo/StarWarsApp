package mappers

import com.google.gson.Gson
import room.entities.people.PeopleEntity
import search.people.models.PeopleFullDataEntity

fun PeopleFullDataEntity.asRoomEntity(): PeopleEntity {
    val gson = Gson()
    return PeopleEntity(
        name = name,
        height = height,
        mass = mass,
        hairColor = hairColor,
        skinColor = skinColor,
        eyeColor = eyeColor,
        birthYear = birthYear,
        gender = gender,
        homeworld = homeworld,
        films =  gson.toJson(films),
        species = gson.toJson(species),
        vehicles = gson.toJson(vehicles),
        starships = gson.toJson(starships),
        isFavorite = isFavorite
    )
}

fun PeopleEntity.asEntity(): PeopleFullDataEntity {
    return PeopleFullDataEntity(
        name = name,
        height = height,
        mass = mass,
        hairColor = hairColor,
        skinColor = skinColor,
        eyeColor = eyeColor,
        birthYear = birthYear,
        gender = gender,
        homeworld = homeworld,
        films = listOf(films),
        species = listOf(species),
        vehicles = listOf(vehicles),
        starships = listOf(starships),
        isFavorite = isFavorite
    )
}