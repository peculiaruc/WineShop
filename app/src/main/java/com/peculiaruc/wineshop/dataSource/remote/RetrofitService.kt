package com.peculiaruc.wineshop.api

import com.peculiaruc.wineshop.dataSource.response.DrinkDetailsResponse
import com.peculiaruc.wineshop.dataSource.response.DrinkResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://www.thecocktaildb.com/api/json/v1/

//https://www.thecocktaildb.com/api/json/v1/1/filter.php?a=Non_Alcoholic

//https://www.thecocktaildb.com/api/json/v1/1/filter.php?a=Alcoholic

//https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=11007

//https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Ordinary_Drink
 //https:www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail

//https:www.thecocktaildb.com/api/json/v1/1/filter.php?g=Champagne_flute
//https:www.thecocktaildb.com/api/json/v1/1/filter.php?g=Cocktail_glass


private val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/"

interface RetrofitService {

    @GET("1/filter.php")
    suspend fun getDrinks(@Query("a")drink: String): DrinkResponse

    @GET("1/lookup.php")
    suspend fun getDrinkDetails(@Query("i")drinkId:String): DrinkDetailsResponse
}

      //add retrofit library
val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL).build()

       //create a signton for easily accessing the api service
object Api {
    val retrofitService: RetrofitService by lazy {
        retrofit.create(RetrofitService::class.java)
    }
}