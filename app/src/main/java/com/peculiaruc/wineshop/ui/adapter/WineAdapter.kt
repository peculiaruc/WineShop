package com.peculiaruc.wineshop.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.peculiaruc.wineshop.databinding.ListWineItemBinding
import com.peculiaruc.wineshop.model.Drink

class WineAdapter(
        private val drink: List<Drink>, private val listener:(Drink)->Unit):
    RecyclerView.Adapter<WineAdapter.WineViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WineViewHolder {
       return WineViewHolder(
               ListWineItemBinding.inflate(
                       LayoutInflater.from(parent.context), parent, false))
    }
    override fun getItemCount(): Int =  drink.size

    override fun onBindViewHolder(holder: WineViewHolder, position: Int) {
        val data: Drink = drink[position]

        with(holder.binding){
            textName.text = data.drinkName
            imageViewWine.load(data.drinkThumb)
            root.setOnClickListener { listener.invoke(data) }
        }
    }
    class WineViewHolder( val binding: ListWineItemBinding): RecyclerView.ViewHolder(binding.root)

}