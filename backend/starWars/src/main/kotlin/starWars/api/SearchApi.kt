package starWars.api

import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query
import starWars.dto.response.PagingPeopleDataDto

interface SearchApi {
    @POST("api/people")
    suspend fun searchPeople(
        @Query("page") page: Int,
        @Query("search") name: String
    ) : Response<PagingPeopleDataDto>
}