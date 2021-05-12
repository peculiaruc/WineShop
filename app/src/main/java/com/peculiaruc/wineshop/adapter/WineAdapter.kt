package com.peculiaruc.wineshop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.peculiaruc.wineshop.databinding.ListWineItemBinding
import com.peculiaruc.wineshop.model.Drink

class WineAdapter(
        private val drink: List<Drink>, private val listener:(Drink)->Unit) : RecyclerView.Adapter<WineAdapter.WineViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WineViewHolder {
       return WineViewHolder(
               ListWineItemBinding.inflate(
                       LayoutInflater.from(parent.context), parent, false))

    }

    override fun getItemCount(): Int {
        return drink.size
    }

    override fun onBindViewHolder(holder: WineViewHolder, position: Int) {
        holder.bindItem(drink[position])

    }

    inner class WineViewHolder(private val binding: ListWineItemBinding): RecyclerView.ViewHolder(binding.root){


        fun bindItem(drink: Drink){
            binding.textName.text = drink.drinkName
            binding.imageViewWine.load(drink.drinkThumb)
            binding.root.setOnClickListener {
                listener.invoke(drink)
            }

        }

    }
}