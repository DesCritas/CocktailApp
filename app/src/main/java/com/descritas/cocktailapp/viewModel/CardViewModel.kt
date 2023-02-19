package com.descritas.cocktailapp.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.descritas.cocktailapp.dto.Card
import com.descritas.cocktailapp.model.CardModel
import com.descritas.cocktailapp.model.CardModelState
import com.descritas.cocktailapp.repository.CardRepository
import com.descritas.cocktailapp.repository.CardRepositoryImpl
import kotlinx.coroutines.launch


class CardViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: CardRepository = CardRepositoryImpl()
    val data: LiveData<CardModel> = repository.data.map { CardModel(it) }
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
                repository.getCard()
                _state.value = CardModelState.Idle

            } catch (e: Exception){
                _state.value = CardModelState.Error
            }

        }

    }
}