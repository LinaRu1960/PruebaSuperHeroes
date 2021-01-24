package cl.eme.superheroes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import cl.eme.superheroes.R
import cl.eme.superheroes.viewModel.SuperHeroeVM
import cl.eme.superheroes.databinding.FragmentListBinding

class ListFragment: Fragment(),OnItemClickListener {

    private lateinit var binding:FragmentListBinding
    private val viewModel: SuperHeroeVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentListBinding.inflate(layoutInflater)
        val adapter=SuperAdapter(this)
        binding.rvHeroList.adapter=adapter
        binding.rvHeroList.layoutManager= GridLayoutManager(this.context,2)
        viewModel.heroList.observe(viewLifecycleOwner,
            {heroList -> heroList?.let{
                adapter.updateList(it)
            }
            })


        return binding.root
    }

    override fun onClick(id: Int) {
        activity?.supportFragmentManager?.
        beginTransaction()?.
        replace(R.id.fc_container,DetailFragment(id))?.
        addToBackStack("back")?.
        commit()
    }
}