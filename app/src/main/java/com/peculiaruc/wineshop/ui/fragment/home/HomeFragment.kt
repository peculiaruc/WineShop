package com.peculiaruc.wineshop.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.peculiaruc.wineshop.R
import com.peculiaruc.wineshop.adapter.ViewPagerAdapter
import com.peculiaruc.wineshop.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var viewPageAdapter: ViewPagerAdapter
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPageAdapter = ViewPagerAdapter(this)
        viewPager = binding.viewOffsetHelperiewPager2
        tabLayout = binding.tabLayout
        viewPager.adapter = viewPageAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position) {
                0 -> tab.text = "Non-Alcohlic CockTail"
                1 -> tab.text = "Alcoholic CockTail"
                2 -> tab.text = "Wines"
                else -> tab.text = "Position ${position + 1}"
            }
        }.attach()
    }

}