package com.peculiaruc.wineshop.ui.fragment.wineNonAcoholic

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peculiaruc.wineshop.dataSource.Repository
import com.peculiaruc.wineshop.model.Drink
import kotlinx.coroutines.launch
import java.lang.Exception

class WineMianViewModel(private val repository: Repository): ViewModel() {

    private val TAG = WineMianViewModel::class.java.simpleName

    private val _drinkLiveData = MutableLiveData<List<Drink>>()
    val drinkLiveData: LiveData<List<Drink>> = _drinkLiveData

    init {
        fetchDrinks()
    }

    private fun fetchDrinks() {
        viewModelScope.launch {
            try {
                val result = repository.getDrinks("Non_Alcoholic")
                _drinkLiveData.value = result.drinks
                Log.d(TAG, "${_drinkLiveData.value}")

            }catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            }
        }
    }

}