package com.peculiaruc.wineshop.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.wineshop.R
import com.peculiaruc.wineshop.adapter.WineAdapter
import com.peculiaruc.wineshop.model.Wine


class WineFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        val wine = ArrayList<Wine>()

        wine.add(Wine("chamdor", "Chamdor", "Red",3000 ))
        wine.add(Wine("chateau_de_fleur", "Chateau De Fleur", "Milk Colour", 2500))
        wine.add(Wine("martnellis", "Martinellis", "Dark Red", 5000))

        val adapter = WineAdapter(wine)

        recyclerView.adapter = adapter
    }

}