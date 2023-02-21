package com.descritas.cocktailapp.repository

import com.descritas.cocktailapp.dto.Card

interface CardRepository {
    //val data: LiveData<Card>

    fun likeById(id: Long)
    suspend fun getCard(): Card




}