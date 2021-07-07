package com.peculiaruc.wineshop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.wineshop.databinding.ListRealwineItemBinding
import com.peculiaruc.wineshop.model.Wine

class RealWineAdapter (private val wineList: ArrayList<Wine>):
    RecyclerView.Adapter<RealWineAdapter.RealWViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RealWViewHolder {
        return RealWViewHolder(
            ListRealwineItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RealWViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = wineList.size

    inner class RealWViewHolder(private val binding: ListRealwineItemBinding): RecyclerView.ViewHolder(binding.root){

    }
}