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
            hair_color = hair_color,
            skin_color = skin_color,
            eye_color = eye_color,
            birth_year = birth_year,
            gender = gender,
            homeworld = homeworld,
            films = films,
            species = species,
            vehicles = vehicles,
            starships = starships,
            created = created,
            edited = edited,
            url = url,
        )
    }