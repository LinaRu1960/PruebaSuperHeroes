package cl.eme.superheroes.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.eme.superheroes.model.Repository
import cl.eme.superheroes.model.SuperHeroe
import kotlinx.coroutines.launch

class SuperHeroeVM: ViewModel() {

    private val repository=Repository()
    val heroList=repository.superList


    fun getHero(superId: Int): LiveData<SuperHeroe> {

        return repository.getSuperHeroe(superId)


    }




    init{

        viewModelScope.launch {
            repository.getSuperHeroesfromApi()
        }

    }}