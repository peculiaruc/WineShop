package com.peculiaruc.wineshop.ui.fragment.wineAcoholic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.peculiaruc.wineshop.R
import com.peculiaruc.wineshop.adapter.WineAdapter
import com.peculiaruc.wineshop.api.Api
import com.peculiaruc.wineshop.dataSource.Repository
import com.peculiaruc.wineshop.databinding.FragmentWineAlcoholicBinding
import com.peculiaruc.wineshop.databinding.FragmentWineBinding
import com.peculiaruc.wineshop.model.Drink
import com.peculiaruc.wineshop.ui.fragment.wineNonAcoholic.WineMainFragment
import com.peculiaruc.wineshop.ui.fragment.wineNonAcoholic.WineMianViewModel
import com.peculiaruc.wineshop.ui.fragment.wineNonAcoholic.WineViewModelFactory


class WineAlcoholicFragment : Fragment() {


    private lateinit var binding: FragmentWineAlcoholicBinding
    private var drinks = mutableListOf<Drink>()
    private lateinit var adapter: WineAdapter

    private val viewModel: WineAlcoholicViewModel by lazy {
        ViewModelProvider(this, WineAlcoholicViewModelFactory(
            Repository(Api.retrofitService, requireContext())))
            .get(WineAlcoholicViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWineAlcoholicBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.drinkLiveData.observe(viewLifecycleOwner, Observer {
            drinks.addAll(it)
            binding.recyclerview.visibility = View.VISIBLE

            val wineAdapter = WineAdapter(this.drinks) {

                // val directions: NavDirections = WineFragmentDirection.wineAction
                findNavController().navigate(R.id.action_homeFragment_to_detailFragment,
                    bundleOf(ID_ARGS to it.drinkId)
                ) }

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
        val  ID_ARGS = WineAlcoholicFragment::class.java.simpleName + "Dirnk-id"
    }
}