package com.descritas.cocktailapp.model

import com.descritas.cocktailapp.dto.Card

data class CardModel (
    val card: Card =
        Card(
        0,
        "default",
        "default",
        "default",
        "default",
        "default",
        //"default",
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
        false),

    val empty: Boolean = false,)

sealed interface CardModelState{
    object Idle:  CardModelState
    object Refresh:  CardModelState

    object Loading: CardModelState
    object Error :  CardModelState
}
