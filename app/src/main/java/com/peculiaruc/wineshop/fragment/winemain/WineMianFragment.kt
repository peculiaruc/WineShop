package com.peculiaruc.wineshop.fragment.winemain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.peculiaruc.wineshop.R
import com.peculiaruc.wineshop.adapter.WineAdapter
import com.peculiaruc.wineshop.api.Api
import com.peculiaruc.wineshop.api.Repository
import com.peculiaruc.wineshop.model.Drink

class WineMianFragment : Fragment() {


    private var drinks = mutableListOf<Drink>()
    private val viewModel: WineMianViewModel by lazy {
        ViewModelProvider(this, WineViewModelFactory(Repository(Api.retrofitService)))
            .get(WineMianViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_wine, container, false)

        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = WineAdapter(requireContext(), drinks)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.drinkLiveData.observe(viewLifecycleOwner, Observer {
            drinks.addAll(it)
      //      binding?.mainRecyclerView?.visibility = View.VISIBLE
        })
    }
}