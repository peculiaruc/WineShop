package com.peculiaruc.wineshop.model

import com.squareup.moshi.Json

data class Drink(

    @Json(name = "strDrink")
    val drinkName:String,
    @Json(name = "strDrinkThumb")
    val drinkThumb:String,
    @Json(name = "idDrink")
    val drinkId:String
)