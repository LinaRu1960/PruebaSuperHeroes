package cl.eme.superheroes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import cl.eme.superheroes.viewModel.SuperHeroeVM
import cl.eme.superheroes.databinding.FragmentBioBinding

class BiographyFragment(id:Int): Fragment() {
    private lateinit var binding: FragmentBioBinding
    private val viewModel: SuperHeroeVM by viewModels()
    private val superId=id

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentBioBinding.inflate(layoutInflater)
        viewModel.getHero(superId).observe(viewLifecycleOwner, {
            binding.tvFullNameValue.text=it.biography.fullName
            binding.tvAlterEgosValue.text=it.biography.alterEgos
            binding.tvFirstAppearanceValue.text=it.biography.firstAppearance
            binding.tvPlaceOfBirthValue.text=it.biography.placeOfBirth
        })


        return binding.root
    }

}