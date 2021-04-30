package com.peculiaruc.wineshop.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.wineshop.R
import com.peculiaruc.wineshop.adapter.WineAdapter
import com.peculiaruc.wineshop.model.WineData


class WineFragment : Fragment() {

    private var wineChamdor = WineData(R.drawable.chamdor, "Chamdor","Red", 3000)
    private var wineChateauDe = WineData(R.drawable.chateau_de_fleur, "Chateau De Fleur", "Milk Colour", 2500)
    private var wineMartinellis = WineData(R.drawable.martinellis, "Martinellis", "Dark Red", 5000)
   // private var winePrice = WineData()

    var wineList: List<WineData> = arrayListOf(wineChamdor, wineChateauDe, wineMartinellis)

//    private lateinit var recyclerView: RecyclerView
//    private lateinit var adapter: WineAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_wine, container, false)

        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = WineAdapter(requireContext(), wineList)
        return root
    }
}