package cl.eme.superheroes.model

import android.app.Application

import androidx.lifecycle.LiveData
import androidx.room.*


/*
[X] dependencies
[X] DAO
[X] cliente de base de datos
[X] Entities
[X] subclase de applicacion -> agregar en el Manifest
[X] type converters
[] testing
 */

@Dao
interface SuperHeroeDao{
    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun loadAllSuper(superHeroeList: List<SuperHeroe>)

    @Query("SELECT * FROM superheroe")
    fun getAllSuper(): LiveData<List<SuperHeroe>>

    @Query("SELECT * FROM superheroe WHERE id=:superId")
    fun getSuper(superId: Int): LiveData <SuperHeroe>
}

// cliente de base de datos
@Database(entities = [SuperHeroe::class],version= 1)
@TypeConverters(Converters:: class)
abstract class SuperHeroeDatabase: RoomDatabase(){
    abstract fun superHeroeDao(): SuperHeroeDao
}

class SuperHeroeApplication: Application(){
    companion object {
        var superHeroeDatabase: SuperHeroeDatabase?= null
    }

    override fun onCreate() {
        super.onCreate()

        superHeroeDatabase= Room.databaseBuilder(
            this, SuperHeroeDatabase::class.java, "db_superHeroe").build()
    }
}