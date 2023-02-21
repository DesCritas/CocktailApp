package com.descritas.cocktailapp.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.descritas.cocktailapp.R
import com.descritas.cocktailapp.viewModel.CardViewModel
import com.descritas.cocktailapp.databinding.FragmentMainBinding

import com.descritas.cocktailapp.load
import com.descritas.cocktailapp.model.CardModelState
import com.google.android.material.snackbar.Snackbar


class MainFragment : Fragment() {
    private val viewModel: CardViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false)

        viewModel.data1.observe(viewLifecycleOwner) {
            with(binding.cocktailCard) {
                cocktailId.text = it.card.id.toString()
                name.text = it.card.name
                cocktailCat.text = it.card.category
                cocktailType.text = it.card.type
                glassType.text = it.card.glass
                content.text = it.card.instruction
                //TODO ingr's&measures
                cocktailImg.load(it.card.imgThumbLink)
                like.isChecked = it.card.likedByMe
            }
        }


        binding.cocktailCard.like.setOnClickListener {
            viewModel.like()
        }

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.refresh()
        }

        viewModel.state.observe(viewLifecycleOwner) { state ->
            binding.progress.isVisible = state is CardModelState.Loading
            if (state is CardModelState.Error) {
                Snackbar.make(binding.root, R.string.error_loading, Snackbar.LENGTH_LONG)
                    .setAction(R.string.retry_loading) {
                        viewModel.refresh()
                    }
                    .show()
            }
            binding.swipeRefresh.isRefreshing = state is CardModelState.Refresh
        }

        return binding.root
    }
}