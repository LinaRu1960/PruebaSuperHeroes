package cl.eme.superheroes.model

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/*
[X] Consumo de API
    [X] Dependencias
    [X] Permiso de Internet
    [X] Interfaz de operaciones
    [X] POJOS
    [X] Cliente de retrofit
 */

interface SuperHeroeAPI {
    @GET("all.json")
    suspend fun getSuperHeroe(): Response<List<SuperHeroe>>
}

// Cliente retrofit

class RetrofitClient {
    companion object {
        private const val BASE_URL = "https://akabab.github.io/superhero-api/api/"
        fun retrofitClient(): SuperHeroeAPI{
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()).build()
            return retrofit.create(SuperHeroeAPI::class.java)
        }
    }
}