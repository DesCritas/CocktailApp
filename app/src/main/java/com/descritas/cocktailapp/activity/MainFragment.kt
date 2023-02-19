package com.descritas.cocktailapp.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.descritas.cocktailapp.viewModel.CardViewModel
import com.descritas.cocktailapp.databinding.FragmentMainBinding

import com.descritas.cocktailapp.load


class MainFragment : Fragment() {
    private val viewModel: CardViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false)

        viewModel.data.observe(viewLifecycleOwner) {
            with(binding.cocktailCard) {
                cocktailId.text = it.card.id.toString()
                name.text = it.card.name
                cocktailCat.text = it.card.category
                cocktailType.text = it.card.type
                glassType.text = it.card.glass
                content.text = it.card.instruction
                //TODO ingr's&measures
                cocktailImg.load(it.card.imgLink)
                like.isChecked = it.card.likedByMe
            }
        }


        binding.cocktailCard.like.setOnClickListener {
            viewModel.like()
        }

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.getCard()
        }

        return binding.root
    }
}