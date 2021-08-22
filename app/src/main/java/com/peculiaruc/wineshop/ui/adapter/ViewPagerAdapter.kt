package com.peculiaruc.wineshop.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.peculiaruc.wineshop.ui.fragment.realwine.RealWineFragment
import com.peculiaruc.wineshop.ui.fragment.wineAcoholic.WineAlcoholicFragment
import com.peculiaruc.wineshop.ui.fragment.wineNonAcoholic.WineMainFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> {
                WineMainFragment()
            }
            1-> {
                WineAlcoholicFragment()
            }
            else-> {
                return RealWineFragment()
            }

        }
    }
}