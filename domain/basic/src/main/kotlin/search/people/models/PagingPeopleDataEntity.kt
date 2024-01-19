package search.people.models

data class PagingPeopleDataEntity (
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<PeopleFullDataEntity>,
)