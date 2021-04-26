package com.peculiaruc.wineshop.adapter

import android.content.ClipData
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.wineshop.R
import com.peculiaruc.wineshop.fragment.DetailFragment
import com.peculiaruc.wineshop.model.Wine

class WineAdapter(val wineList: ArrayList<Wine> ) : RecyclerView.Adapter<WineAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_wine_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return wineList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(wineList[position])
    }



     class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

       fun bindItem(wine: Wine){
           val textName = itemView.findViewById<TextView>(R.id.text_name)
           val textColour = itemView.findViewById<TextView>(R.id.text_colour)
           val textPrice = itemView.findViewById<TextView>(R.id.textprice)
           val imageWine = itemView.findViewById<ImageView>(R.id.imageView_wine)
           textName.text = wine.name
           textColour.text = wine.colour
           textPrice.text = wine.price.toString()


       }

    }

}