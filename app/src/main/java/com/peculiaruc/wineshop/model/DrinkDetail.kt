package com.peculiaruc.wineshop.model

import com.squareup.moshi.Json

data class DrinkDetail(
    @Json(name = "strDrink")
    val drinkName:String,
    @Json(name = "strDrinkThumb")
    val drinkThumb:String,
    @Json(name = "idDrink")
    val drinkId:String,
    @Json(name = "strInstructions")
    val instructions:String
)