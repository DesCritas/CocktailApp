package com.descritas.cocktailapp.viewModel

import android.app.Application
import androidx.lifecycle.*
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

    init{
        getCard()
    }

    fun like() {
        //TODO
    }

    fun getCard(){
        viewModelScope.launch {
            try {
                _state.value = CardModelState.Loading
                val curCard = repository.getCard()
                _data1.postValue(CardModel(card = curCard, ingredientsList = emptyList()))//TODO вернуть в igredientsList список ингридиентов
                _state.value = CardModelState.Idle

            } catch (e: Exception){
                _state.value = CardModelState.Error
            }

        }

    }

    fun refresh(){
        viewModelScope.launch {
            try {
                _state.value = CardModelState.Refresh
                _data1.postValue(CardModel(card = repository.getCard()))
                _state.value = CardModelState.Idle

            } catch (e: Exception){
                _state.value = CardModelState.Error
            }

        }
    }
}