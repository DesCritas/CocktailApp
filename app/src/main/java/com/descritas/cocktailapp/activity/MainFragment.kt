package com.descritas.cocktailapp.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.descritas.cocktailapp.R
import com.descritas.cocktailapp.adapter.RWAdapter
import com.descritas.cocktailapp.databinding.FragmentMainBinding
import com.descritas.cocktailapp.dto.Data
import com.descritas.cocktailapp.model.CardModelState
import com.descritas.cocktailapp.usecase.CardFillerUseCase
import com.descritas.cocktailapp.viewModel.CardViewModel
import com.google.android.material.snackbar.Snackbar


class MainFragment : Fragment() {
    private val viewModel: CardViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView

    private val cardFillerUseCase = CardFillerUseCase()

    private val adapter: RWAdapter = RWAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false)

        recyclerView = binding.list
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        recyclerView.adapter = adapter

        viewModel.data1.observe(viewLifecycleOwner) { cardModel ->
            val dataList: ArrayList<Data> = cardFillerUseCase.cardFiller(cardModel)
            adapter.submitList(dataList)
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
            if (state == CardModelState.Loading) {
                findNavController().navigate(R.id.action_mainFragment_to_onBoardingFragment)
            }
        }
        return binding.root
    }
}
