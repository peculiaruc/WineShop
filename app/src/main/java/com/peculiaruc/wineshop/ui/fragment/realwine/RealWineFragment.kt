package com.peculiaruc.wineshop.ui.fragment.realwine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.peculiaruc.wineshop.R
import com.peculiaruc.wineshop.databinding.FragmentRealWineBinding


class RealWineFragment : Fragment() {

    private lateinit var binding: FragmentRealWineBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentRealWineBinding.inflate(inflater)
        return binding.root
    }


}