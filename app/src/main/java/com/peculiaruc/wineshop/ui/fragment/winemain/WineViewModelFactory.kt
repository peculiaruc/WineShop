package com.peculiaruc.wineshop.ui.fragment.winemain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.peculiaruc.wineshop.db.Repository
import java.lang.IllegalArgumentException

class WineViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WineMianViewModel::class.java)){
            return WineMianViewModel(repository) as T
        }else{
            throw IllegalArgumentException("UNKNOW CLASS")
        }
    }

}