package com.descritas.cocktailapp.api

import com.descritas.cocktailapp.dto.Card
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

private const val URL = "https://www.thecocktaildb.com/api/json/v1/1/random.php"

private val okhttp = OkHttpClient.Builder()
    .connectTimeout(30,TimeUnit.SECONDS)
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(URL)
    .client(okhttp)
    .build()

interface CardApiService {
    @GET
    fun getCocktailCard(): Call<Card>

}

object CocktailApi {
    val retrofitService: CardApiService by lazy {
        retrofit.create(CardApiService::class.java)
    }
}