package com.peculiaruc.wineshop.ui.fragment.winedetailNonAcoholic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.peculiaruc.wineshop.dataSource.Repository
import java.lang.IllegalArgumentException

class WineDetailViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WineDetailViewModel::class.java)){
            return WineDetailViewModel(repository) as T
        }else{
            throw IllegalArgumentException("UNKNOW CLASS")
        }
    }


}