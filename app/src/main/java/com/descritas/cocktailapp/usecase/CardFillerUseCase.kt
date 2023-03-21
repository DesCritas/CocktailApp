package com.descritas.cocktailapp.usecase

import com.descritas.cocktailapp.adapter.RWAdapter
import com.descritas.cocktailapp.dto.Data
import com.descritas.cocktailapp.model.CardModel

class CardFillerUseCase {

    fun cardFiller(cardModel: CardModel): ArrayList<Data>{
        val dataList1: ArrayList<Data> = ArrayList()
        dataList1.add(Data(RWAdapter.VIEW_TYPE_ONE, cardModel.card,null))
        for (item in cardModel.ingredientsList) {
            dataList1.add(Data(RWAdapter.VIEW_TYPE_TWO, cardModel.card, if (cardModel.ingredientsList.isEmpty()) null else item))
        }
        return dataList1
    }
}