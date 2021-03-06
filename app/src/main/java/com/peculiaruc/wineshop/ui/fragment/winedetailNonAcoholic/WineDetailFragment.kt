package com.peculiaruc.wineshop.ui.fragment.winedetailNonAcoholic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.peculiaruc.wineshop.api.Api
import com.peculiaruc.wineshop.dataSource.Repository
import com.peculiaruc.wineshop.databinding.FragmentDetailBinding
import com.peculiaruc.wineshop.ui.fragment.wineNonAcoholic.WineMainFragment.Companion.ID_ARGS
import com.peculiaruc.wineshop.model.DrinkDetail


class WineDetailFragment : Fragment() {

    private lateinit var binding:FragmentDetailBinding
    private val drinksDetail = mutableListOf<DrinkDetail>()


    private val  viewModel: WineDetailViewModel by lazy {
        ViewModelProvider(this, WineDetailViewModelFactory(
            Repository(Api.retrofitService,
            requireContext()
        )
        ))
                .get(WineDetailViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var id = ""
        arguments?.let {
            id = it.getString(ID_ARGS).toString()
        }
        viewModel.fetchDrinkDetail(id)
        viewModel.drinksDetailLiveData.observe(viewLifecycleOwner, Observer {
            binding.textInstruction.text = it[0].instructions
            binding.imageThumbs.load(it[0].drinkThumb)
            activity?.title = it[0].drinkName
        })

    }
}