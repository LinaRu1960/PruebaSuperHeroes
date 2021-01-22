package cl.eme.superheroes.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

//POJOS
@Entity (tableName = "superHeroe")
data class SuperHeroe(
    @PrimaryKey val id: Int,
    val name: String,
    val slug: String,
    @Embedded val powerstats: List<Int>,
    @Embedded val appearance: List<Appearance>,
    @Embedded val biography: List<Biography>,
    @Embedded val work: List<String>,
    @Embedded val connections: List<String>,
    @Embedded val images: List<String>
)

data class Connection(val groupAffiliation: String, val relatives: String)

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