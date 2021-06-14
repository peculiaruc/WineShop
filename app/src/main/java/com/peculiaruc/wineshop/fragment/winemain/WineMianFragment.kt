package com.peculiaruc.wineshop.fragment.winemain

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.peculiaruc.wineshop.R
import com.peculiaruc.wineshop.adapter.WineAdapter
import com.peculiaruc.wineshop.api.Api
import com.peculiaruc.wineshop.api.Repository
import com.peculiaruc.wineshop.databinding.FragmentWineBinding
import com.peculiaruc.wineshop.model.Drink

class WineMianFragment : Fragment() {

    private lateinit var binding: FragmentWineBinding
    private var drinks = mutableListOf<Drink>()
    private lateinit var adapter: WineAdapter

    private val viewModel: WineMianViewModel by lazy {
        ViewModelProvider(this, WineViewModelFactory(Repository(Api.retrofitService)))
            .get(WineMianViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWineBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.drinkLiveData.observe(viewLifecycleOwner, Observer {
            drinks.addAll(it)
            binding.recyclerview.visibility = View.VISIBLE

            val wineAdapter = WineAdapter(this.drinks) {

               // val directions: NavDirections = WineFragmentDirection.wineAction
                findNavController().navigate(R.id.action_wineFragment_to_detailFragment,
                        bundleOf(ID_ARGS to it.drinkId)) }

            with(binding) {
                recyclerview.apply {
                    adapter = wineAdapter
                    setHasFixedSize(true)
                    layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                }
            }
        })
    }

    companion object {
        val  ID_ARGS = WineMianFragment::class.java.simpleName + "Dirnk-id"
    }
}

