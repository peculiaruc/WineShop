package com.peculiaruc.wineshop.ui.fragment.realwine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.peculiaruc.wineshop.R
import com.peculiaruc.wineshop.databinding.FragmentRealWineBinding
import com.peculiaruc.wineshop.model.Wine


class RealWineFragment : Fragment() {

    private lateinit var binding: FragmentRealWineBinding
    private var wineList: ArrayList<Wine> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentRealWineBinding.inflate(inflater)
        return binding.root
    }


}