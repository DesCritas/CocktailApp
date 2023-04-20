package com.descritas.cocktailapp.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.descritas.cocktailapp.adapter.RWAdapter
import com.descritas.cocktailapp.dto.Card
import com.descritas.cocktailapp.dto.Data
import com.descritas.cocktailapp.dto.Ingredient
import com.descritas.cocktailapp.model.CardModel
import com.descritas.cocktailapp.model.CardModelState
import com.descritas.cocktailapp.repository.CardRepository
import com.descritas.cocktailapp.repository.CardRepositoryImpl
import kotlinx.coroutines.launch

class CardViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: CardRepository = CardRepositoryImpl()
    private val _data1 = MutableLiveData(CardModel())
    val data1: LiveData<CardModel>
        get() = _data1
    private val _state = MutableLiveData<CardModelState>(CardModelState.Idle)
    val state: LiveData<CardModelState>
        get() = _state

    init {
        getCard()
    }

    fun getCard() {
        viewModelScope.launch {
            try {
                _state.value = CardModelState.Loading
                val curCard = repository.getCard()

                _data1.postValue(CardModel(card = curCard, ingredientsList = getIngredients(curCard)))
                _state.value = CardModelState.Idle
            } catch (e: Exception) {
                _state.value = CardModelState.Error
            }
        }
    }

    fun refresh() {
        viewModelScope.launch {
            try {
                _state.value = CardModelState.Refresh
                val curCard = repository.getCard()
                val temp = getIngredients(curCard)
                Log.d("response", temp.toString())
                _data1.postValue(CardModel(card = curCard, ingredientsList = temp))
                _state.value = CardModelState.Idle
            } catch (e: Exception) {
                _state.value = CardModelState.Error
            }
        }
    }

    fun cardFiller2(): ArrayList<Data> {
        val dataList1: ArrayList<Data> = ArrayList()
        val model = data1.value
        val card = model?.let { Data(RWAdapter.VIEW_TYPE_ONE, it.card, null) }

        card?.let { dataList1.add(it) }
        data1.value?.ingredientsList?.forEach { item ->
            if (model != null) {
                dataList1.add(
                    Data(RWAdapter.VIEW_TYPE_TWO, model.card, if (model.ingredientsList.isEmpty()) null else item)
                )
            }
        }
        return dataList1
    }
    fun getIngredients(curCard: Card): MutableList<Ingredient> {
        val listIngr = listOf<String?>(
            curCard.ingr1,
            curCard.ingr2,
            curCard.ingr3,
            curCard.ingr4,
            curCard.ingr5,
            curCard.ingr6,
            curCard.ingr7,
            curCard.ingr8,
            curCard.ingr9,
            curCard.ingr10,
            curCard.ingr11,
            curCard.ingr12,
            curCard.ingr13,
            curCard.ingr14,
            curCard.ingr15,
        )
        val listMeasure = listOf<String?>(
            curCard.measure1,
            curCard.measure2,
            curCard.measure3,
            curCard.measure4,
            curCard.measure5,
            curCard.measure6,
            curCard.measure7,
            curCard.measure8,
            curCard.measure9,
            curCard.measure10,
            curCard.measure11,
            curCard.measure12,
            curCard.measure13,
            curCard.measure14,
            curCard.measure15,
        )

        val ingredientsList1: MutableList<Ingredient> =
            mutableListOf<Ingredient>()

        for (i in 0..listIngr.size - 1) {
            ingredientsList1.add(Ingredient(listIngr[i], listMeasure[i]))
        }
        return ingredientsList1
    }
}
