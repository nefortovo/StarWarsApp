package starWars.dto.response

import com.google.gson.annotations.SerializedName

data class PagingPeopleDataDto(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<PeopleFullDataDto>,
    )
