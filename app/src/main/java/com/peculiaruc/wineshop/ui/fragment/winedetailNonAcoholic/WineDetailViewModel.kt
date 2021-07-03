package com.peculiaruc.wineshop.ui.fragment.winedetailNonAcoholic

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peculiaruc.wineshop.dataSource.Repository
import com.peculiaruc.wineshop.model.DrinkDetail
import kotlinx.coroutines.launch

class WineDetailViewModel(private val repository: Repository): ViewModel() {

    private val _drinksDetailLiveData = MutableLiveData<List<DrinkDetail>>()

    val drinksDetailLiveData:  LiveData<List<DrinkDetail>> = _drinksDetailLiveData

    private  val TAG = WineDetailViewModel::class.java.simpleName

    fun fetchDrinkDetail(id: String){
        try {
            viewModelScope.launch {
                _drinksDetailLiveData.value = repository.getDrinkDetails(id).drinks
            }
        }catch (e:Exception){
            Log.e(TAG, e.message.toString())
        }
    }
}