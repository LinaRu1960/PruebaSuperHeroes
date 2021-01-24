package cl.eme.superheroes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import cl.eme.superheroes.viewModel.SuperHeroeVM
import cl.eme.superheroes.databinding.FragmentDetailBinding
import coil.load
import com.google.android.material.tabs.TabLayoutMediator

class DetailFragment(id:Int): Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val viewModel: SuperHeroeVM by viewModels()
    private val superId=id

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentDetailBinding.inflate(layoutInflater)

        viewModel.getHero(superId).observe(viewLifecycleOwner,{
            binding.tvHeroNameDetail.text=it.name
            binding.ivHeroImageLarge.load(it.images.md)
            binding.tvAlingmentDetail.text=it.biography.alignment.toUpperCase()
            binding.tvPublisher.text=it.biography.publisher
            binding.tvAlias.text= it.biography.aliases.joinToString ()
            binding.tvGender1.text= it.appearance.gender
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val detailAdapter=DetailAdapter(this,superId)
        binding.detailTabs.adapter=detailAdapter
        TabLayoutMediator(binding.tabDetailHero,binding.detailTabs){tab,position->
            when(position){
                0->tab.text="Biography"
                1->tab.text="Appear"
                2->tab.text="Power Stats"
                3->tab.text="Other"
            }
        }.attach()

    }

}