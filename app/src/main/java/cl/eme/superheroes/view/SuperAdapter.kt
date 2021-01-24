package cl.eme.superheroes.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.eme.superheroes.databinding.ItemListSuperheroeBinding
import cl.eme.superheroes.model.SuperHeroe
import coil.load

class SuperAdapter(val listener:OnItemClickListener): RecyclerView.Adapter<SuperVH>() {

    private val superList=mutableListOf<SuperHeroe>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperVH {
        val binding=ItemListSuperheroeBinding.inflate(LayoutInflater.from(parent.context))
        return SuperVH(binding)
    }

    override fun onBindViewHolder(holder: SuperVH, position: Int) {
        val superHero=superList[position]
        holder.itemView.setOnClickListener{
            listener.onClick(superHero.id)
        }
        holder.bind(superHero)


    }

    override fun getItemCount(): Int {
        return superList.size
    }

    fun updateList(list:List<SuperHeroe>){
        superList.clear()
        superList.addAll(list)
        notifyDataSetChanged()
    }
}

class SuperVH(private val binding:ItemListSuperheroeBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(superHero: SuperHeroe) {
        binding.tvHeroName.text=superHero.name
        binding.imageView.load(superHero.images.sm)


    }


}