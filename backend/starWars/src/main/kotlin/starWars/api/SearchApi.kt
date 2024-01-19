package starWars.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import starWars.dto.response.PagingPeopleDataDto

interface SearchApi {

    @GET("people/")
    suspend fun searchPeople(
        @Query("page") page: Int,
        @Query("search") search: String,
    ) : Response<PagingPeopleDataDto>

    @GET("people")
    suspend fun getPeople(
        @Query("search") name: String
    ) : Response<PagingPeopleDataDto>

}