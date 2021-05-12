package com.peculiaruc.wineshop.fragment.winemain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.peculiaruc.wineshop.R
import com.peculiaruc.wineshop.adapter.WineAdapter
import com.peculiaruc.wineshop.api.Api
import com.peculiaruc.wineshop.api.Repository
import com.peculiaruc.wineshop.databinding.FragmentWineBinding
import com.peculiaruc.wineshop.model.Drink

class WineMianFragment : Fragment() {

    private var binding: FragmentWineBinding? = null
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
        binding = FragmentWineBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.drinkLiveData.observe(viewLifecycleOwner, Observer {
            drinks.addAll(it)
            binding?.recyclerview?.visibility = View.VISIBLE
        })

        val adapter = WineAdapter(drinks){
            requireView().findNavController().navigate(R.id.action_wineFragment_to_detailFragment,
            bundleOf(ID_ARGS to  it.drinkId))
        }
        binding?.recyclerview?.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding?.recyclerview?.adapter = adapter
    }

    companion object {
        val  ID_ARGS = WineMianFragment::class.java.simpleName + "Dirnk-id"
    }
}

