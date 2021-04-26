package com.peculiaruc.wineshop.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.wineshop.R

class WineAdapter : RecyclerView.Adapter<WineAdapter.ViewHolder>() {

    private val name = arrayOf(
            "Chamdor", "Chateau De Fleur", "Martinellis"
    )

    private val colour = arrayOf(
            "Red", " Milk Color", "Dark Red"
    )

    private val price = arrayOf("#3000", "#2500", "#5000"

    )

    private  val image = arrayOf(
            "chamdor", "chateau_de_fleur", "martnellis"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var itemName : TextView
        var itemColour: TextView
        var itemPrice: TextView
        var itemImage: ImageView

        init {
            itemName = itemView.findViewById(R.id.text_name)
            itemColour = itemView.findViewById(R.id.text_colour)
            itemPrice = itemView.findViewById(R.id.textprice)
            itemImage = itemView.findViewById(R.id.imageView_wine)
        }
    }

}