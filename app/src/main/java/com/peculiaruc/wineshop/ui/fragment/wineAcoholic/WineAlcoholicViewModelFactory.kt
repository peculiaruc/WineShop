package com.peculiaruc.wineshop.ui.fragment.wineAcoholic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.peculiaruc.wineshop.dataSource.Repository
import java.lang.IllegalArgumentException

class WineAlcoholicViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WineAlcoholicViewModel::class.java)){
            return WineAlcoholicViewModel(repository) as T
        }else{
            throw IllegalArgumentException("UNKNOW CLASS")
        }
    }

}