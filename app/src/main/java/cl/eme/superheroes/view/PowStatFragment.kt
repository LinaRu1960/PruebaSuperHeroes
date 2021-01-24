package cl.eme.superheroes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import cl.eme.superheroes.viewModel.SuperHeroeVM
import cl.eme.superheroes.databinding.FragmentPowStatsBinding

class PowStatFragment(id:Int): Fragment() {
    private lateinit var binding: FragmentPowStatsBinding
    private val viewModel: SuperHeroeVM by viewModels()
    private val superId=id

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentPowStatsBinding.inflate(layoutInflater)
        viewModel.getHero(superId).observe(viewLifecycleOwner, {
            binding.rbIntelligence.progress= (it.powerstats.intelligence.toFloat()).toInt()
            binding.rbCombat.progress= (it.powerstats.combat.toFloat()).toInt()
            binding.rbDurability.progress= (it.powerstats.durability.toFloat()).toInt()
            binding.rbPower.progress= (it.powerstats.power.toFloat()).toInt()
            binding.rbSpeed.progress= (it.powerstats.speed.toFloat()).toInt()
            binding.rbStrength.progress= (it.powerstats.strength.toFloat()).toInt()

        })


        return binding.root
    }


}