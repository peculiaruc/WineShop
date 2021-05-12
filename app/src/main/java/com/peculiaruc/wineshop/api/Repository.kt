package com.peculiaruc.wineshop.api

import com.peculiaruc.wineshop.api.Api.retrofitService

class Repository(private val retrofitService: RetrofitService) {
    suspend fun getDrinks(drink:String) = retrofitService.getDrinks(drink)

    suspend fun getDrinkDetails(id:String) = retrofitService.getDrinkDetails(id)
}