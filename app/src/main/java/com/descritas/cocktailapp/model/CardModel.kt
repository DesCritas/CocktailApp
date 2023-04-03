package com.descritas.cocktailapp.model

import com.descritas.cocktailapp.dto.Card
import com.descritas.cocktailapp.dto.Ingredient

data class CardModel(
    val card: Card =
        Card(
            0,
            "default",
            "default",
            "default",
            "default",
            "default",
            // "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            "default",
            false
        ),

    val empty: Boolean = false,
    val ingredientsList: List<Ingredient> = emptyList<Ingredient>()
)

sealed interface CardModelState {
    object Idle : CardModelState
    object Refresh : CardModelState

    object Loading : CardModelState
    object Error : CardModelState
}
