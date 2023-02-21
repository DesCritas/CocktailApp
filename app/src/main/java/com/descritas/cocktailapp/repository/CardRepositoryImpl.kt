package com.descritas.cocktailapp.repository

import android.util.Log
import com.descritas.cocktailapp.api.CocktailApi
import com.descritas.cocktailapp.dto.Card
import com.descritas.cocktailapp.error.ApiError
import com.descritas.cocktailapp.error.NetworkError
import com.descritas.cocktailapp.error.UnknownError
import java.io.IOException

class CardRepositoryImpl : CardRepository {

    override suspend fun getCard(): Card {
        Log.d("response", "starts there")

        try {
            Log.d("response", "try")
            val response = CocktailApi.retrofitService.getCocktailCard()
            Log.d("response", "step1")
            if (!response.isSuccessful) {
                Log.d("response", "$response")
                throw ApiError(response.code(), response.message())
            }
            Log.d("response", "step1 successfully")
            val body = response.body() ?: throw ApiError(response.code(), response.message())
            println(body)
            Log.d("response", "$body")
            val cardItem = body.cards[0]
            val strCardItem = cardItem.toString()
            Log.d("response", strCardItem)
            //_data1.postValue(CardModel(card = cardItem))
            return cardItem
        } catch (e: IOException) {
            throw NetworkError
        } catch (e: Exception) {
            throw UnknownError
        }

    }

    override fun likeById(id: Long) {
        TODO("Not yet implemented")
    }
}