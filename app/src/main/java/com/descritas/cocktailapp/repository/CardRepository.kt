package com.descritas.cocktailapp.repository

import androidx.lifecycle.LiveData
import com.descritas.cocktailapp.dto.Card
import javax.security.auth.callback.Callback

interface CardRepository {
    val data: LiveData<Card>

    fun likeById(id: Long)
    suspend fun getCard(): Card




}