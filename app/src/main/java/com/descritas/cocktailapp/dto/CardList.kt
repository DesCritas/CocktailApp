package com.descritas.cocktailapp.dto

import com.google.gson.annotations.SerializedName

data class CardList(
    @SerializedName("drinks")
    val cards: List<Card>
)