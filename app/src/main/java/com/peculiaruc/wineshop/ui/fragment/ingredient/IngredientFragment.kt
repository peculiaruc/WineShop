package com.peculiaruc.wineshop.ui.fragment.ingredient

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.peculiaruc.wineshop.R


class IngredientFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ingredient, container, false)
    }

   fun bind(){
  //     findNavController().navigate(<Destination or action>)
   }
}