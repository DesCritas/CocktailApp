package com.descritas.cocktailapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.descritas.cocktailapp.dto.Card
import com.descritas.cocktailapp.model.CardModel
import com.descritas.cocktailapp.repository.CardRepository
import com.descritas.cocktailapp.repository.CardRepositoryImpl


class CardViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: CardRepository = CardRepositoryImpl()
    val _data = MutableLiveData(CardModel())
    val data: LiveData<CardModel>
        get() = _data

    init{
        getCard()
    }

    fun likeById(id: Long) {

    }

    fun getCard(){
        _data.value = CardModel()
        repository.getCard(object : CardRepository.GetCallback{
            override fun onSuccess(card: Card) {
                _data.value = CardModel(cards = card)
            }

            override fun onError(e: Exception) {
                _data.value = CardModel(error = true)
            }

        })
    }
}