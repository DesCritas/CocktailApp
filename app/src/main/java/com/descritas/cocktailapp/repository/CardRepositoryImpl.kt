package com.descritas.cocktailapp.repository

import com.descritas.cocktailapp.api.CocktailApi
import com.descritas.cocktailapp.dto.Card
import com.descritas.cocktailapp.error.ApiError
import com.descritas.cocktailapp.error.NetworkError
import com.descritas.cocktailapp.error.UnknownError
import retrofit2.Call
import retrofit2.Response
import java.io.IOException
import javax.security.auth.callback.Callback

class CardRepositoryImpl : CardRepository {

    override fun getCard(callback: CardRepository.GetCallback) {
       CocktailApi.retrofitService.getCocktailCard()
           .enqueue(object : retrofit2.Callback<Card>{
           override fun onResponse(call: Call<List<Card>>, response: Response<Card>){
               if (!response.isSuccessful){
                   callback.onError(RuntimeException(response.message()))
                   return
               }
               val body = response.body() ?: run{
                   callback.onError(RuntimeException("body is null"))
                   return
               }
               callback.onSuccess(listOf<Card>(body) )
           }
           override fun onFailure(call: Call<Card>, t: Throwable){
               callback.onError(RuntimeException(t))
           }
       })
    }

    override fun likeById(id: Long) {
        TODO("Not yet implemented")
    }
}