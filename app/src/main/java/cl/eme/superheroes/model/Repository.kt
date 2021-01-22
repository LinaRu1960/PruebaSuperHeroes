package cl.eme.superheroes.model

import androidx.lifecycle.LiveData

class Repository {

    private val database= SuperHeroeApplication.superHeroeDatabase!!
    val superList= database.superHeroeDao().getAllSuper()

    suspend fun getSuperHeroesfromApi(){
        val response= RetrofitClient.retrofitClient().getSuperHeroe()

        when(response.isSuccessful){
            true -> {response.body()?.let {
                database.superHeroeDao().loadAllSuper(it)
            }}
            false ->{

            }
        }
    }
    fun getSuperHeroe(superId:Int): LiveData<SuperHeroe>{
        return database.superHeroeDao().getSuper(superId)
    }
}