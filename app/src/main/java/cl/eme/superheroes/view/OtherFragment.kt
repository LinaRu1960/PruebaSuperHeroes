package cl.eme.superheroes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import cl.eme.superheroes.viewModel.SuperHeroeVM
import cl.eme.superheroes.databinding.FragmentOtherBinding

class OtherFragment(id:Int): Fragment() {
    private lateinit var binding: FragmentOtherBinding
    private val viewModel: SuperHeroeVM by viewModels()
    private val superId=id

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentOtherBinding.inflate(layoutInflater)
        viewModel.getHero(superId).observe(viewLifecycleOwner, {
            binding.tvWorkValue.text=it.work.occupation
            binding.tvBaseValue.text=it.work.base
            binding.tvGroupAffilValue.text=it.connections.groupAffiliation
            binding.tvRelativesValue.text=it.connections.relatives
        })


        return binding.root
    }


}