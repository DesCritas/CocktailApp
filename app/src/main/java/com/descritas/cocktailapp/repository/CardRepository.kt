package com.descritas.cocktailapp.repository

import com.descritas.cocktailapp.dto.Card
import javax.security.auth.callback.Callback

interface CardRepository {

    fun likeById(id: Long)
    fun getCard(callback: GetCallback)

    interface GetCallback{
        fun onSuccess(card: List<Card>)
        fun onError(e: Exception)
    }


}