package com.peculiaruc.wineshop.model.response

import com.peculiaruc.wineshop.model.DrinkDetail

data class DrinkDeatailsResponse(
    val drinks:List<DrinkDetail>
)