package com.descritas.cocktailapp.api

import com.descritas.cocktailapp.BuildConfig
import com.descritas.cocktailapp.dto.CardList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

private const val URL = "https://www.thecocktaildb.com/api/json/v1/1/"

private val logging = HttpLoggingInterceptor().apply {
    if (BuildConfig.DEBUG) {
        level = HttpLoggingInterceptor.Level.BODY
    }
}

private val okhttp = OkHttpClient.Builder()
    .addInterceptor(logging)
    .build()



private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(URL)
    .client(okhttp)
    .build()

interface CardApiService {
    @GET("random.php")
    suspend fun getCocktailCard(): Response<CardList>

}

object CocktailApi {
    val retrofitService: CardApiService by lazy {
        retrofit.create(CardApiService::class.java)
    }
}