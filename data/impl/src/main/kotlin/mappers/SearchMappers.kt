package mappers

import search.people.models.PagingPeopleDataEntity
import search.people.models.PeopleFullDataEntity
import starWars.dto.response.PagingPeopleDataDto
import starWars.dto.response.PeopleFullDataDto

    fun PagingPeopleDataDto.asEntity(): PagingPeopleDataEntity {
        return PagingPeopleDataEntity(
            count = count,
            next = next,
            previous = previous,
            results = results.map { it.asEntity() },
        )
    }

    fun PeopleFullDataDto.asEntity(): PeopleFullDataEntity {
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
            films = films,
            species = species,
            vehicles = vehicles,
            starships = starships,
        )
    }