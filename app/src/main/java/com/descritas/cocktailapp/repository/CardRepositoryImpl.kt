package com.descritas.cocktailapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private var card = Card(0,"","","","","","",false,)

    override val data: LiveData<Card> = MutableLiveData(card)

            override suspend fun getCard():Card {

                try {
                    val response = CocktailApi.retrofitService.getCocktailCard()
                    if (!response.isSuccessful) {
                        throw ApiError(response.code(), response.message())
                    }
                    val body = response.body() ?: throw ApiError(response.code(), response.message())
                    println(body)
                    return body
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