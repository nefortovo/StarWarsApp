package starWars.dto.response

import com.google.gson.annotations.SerializedName


data class PeopleFullDataDto (
    @SerializedName("name")
    val name: String,
    @SerializedName("height")
    val height: String,
    @SerializedName("mass")
    val mass: String,
    @SerializedName("hair_color")
    val hairColor: String,
    @SerializedName("skin_color")
    val skinColor: String,
    @SerializedName("eye_color")
    val eyeColor: String,
    @SerializedName("birth_year")
    val birthYear: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("homeworld")
    val homeworld: String,
    @SerializedName("films")
    val films: List<String> = emptyList(),
    @SerializedName("species")
    val species: List<String> = emptyList(),
    @SerializedName("vehicles")
    val vehicles: List<String> = emptyList(),
    @SerializedName("starships")
    val starships: List<String> = emptyList(),
    @SerializedName("created")
    val created: String,
    @SerializedName("edited")
    val edited: String,
    @SerializedName("url")
    val url: String,
)