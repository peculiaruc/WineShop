package com.peculiaruc.wineshop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.peculiaruc.wineshop.R
import com.peculiaruc.wineshop.model.Drink

class WineAdapter(val context: Context, val drink: List<Drink> ) : RecyclerView.Adapter<WineAdapter.WineViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WineViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.list_wine_item, parent, false)
       return WineViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return drink.size
    }

    override fun onBindViewHolder(holder: WineViewHolder, position: Int) {
       val drink = drink[position]
        holder.bindItem(drink)
//        holder.pos = position
    }

    inner class WineViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var  textName: TextView
        lateinit var imageWine: ImageView
//        var pos = -1


        fun bindItem(drink: Drink){
           textName = itemView.findViewById(R.id.text_name)
           imageWine = itemView.findViewById(R.id.imageView_wine)

            textName.text = drink.drinkName
            imageWine.load(drink.drinkThumb)
        }

    }
}
//class WineAdapter(val context: Context, val wineList: List<WineModel> ) : RecyclerView.Adapter<WineAdapter.ViewHolder>() {

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//         val itemView = layoutInflater.inflate(R.layout.list_wine_item, parent, false)
//        return ViewHolder(itemView)
//    }
//
//    override fun getItemCount() = wineList.size
//
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//       val wineData = wineList[position]
//        holder.bindItem(wineData)
//        holder.pos = position
//    }
//
//     class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//
//         lateinit var  textName: TextView
//         lateinit var textColour: TextView
//         lateinit var textPrice: TextView
//         lateinit var imageWine: ImageView
//         var pos = -1
//
//       fun bindItem(wine: WineModel){
//           textName = itemView.findViewById(R.id.text_name)
//           textColour = itemView.findViewById(R.id.text_colour)
//           textPrice = itemView.findViewById(R.id.textprice)
//           imageWine = itemView.findViewById(R.id.imageView_wine)
//
//           textName.text = wine.name
//           textColour.text = wine.colour
//           textPrice.text = wine.price.toString()
//           imageWine.setImageResource(wine.image)
//
//
//       }
//
//    }
//
//}