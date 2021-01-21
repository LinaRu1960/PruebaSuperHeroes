package cl.eme.superheroes

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/*
[] Consumo de API
    [X] Dependencias
    [X] Permiso de Internet
    [X] Interfaz de operaciones
    [X] POJOS
    [X] Cliente de retrofit
 */

interface SuperHeroeAPI {
    @GET("all")
    suspend fun getSuperHeroe(): Response<List<SuperHeroe>>
}
    //POJO
    data class SuperHeroe(
        val id: Int,
        val name: String,
        val slug: String,
        val powerstats: List<Int>,
        val appearance: List<Appearance>,
        val biography: List<Biography>,
        val work: List<String>,
        val connections: List<String>,
        val images: List<String>
    )
    data class Appearance(
        val gender: String,
        val race: String,
        val height: List<String>,
        val weight: List<String>,
        val eyeColor:String,
        val hairColor:String
    )

    data class Biography(
        val fullName: String,
        val alterEgos: String,
        val aliases: List<String>,
        val placeOfBirth: String,
        val firstAppearance: String,
        val publisher: String,
        val alignment: String
    )

// Cliente retrofit
const val BASE_URL = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/all.json"
class RetrofitClient {
    companion object {
        fun instance(): SuperHeroeAPI{
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()).build()
            return retrofit.create(SuperHeroeAPI::class.java)
        }
    }
}