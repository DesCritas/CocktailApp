package com.descritas.cocktailapp.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.descritas.cocktailapp.viewModel.CardViewModel
import com.descritas.cocktailapp.databinding.FragmentMainBinding
import com.descritas.cocktailapp.adapter.CardAdapter
import com.descritas.cocktailapp.adapter.OnInteractionListener


class MainFragment : Fragment() {
    private val viewModel: CardViewModel by activityViewModels()

    override fun OnCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        val adapter = CardAdapter(object : OnInteractionListener {
            override fun onLike(id: Long) {
                viewModel.likeById(id)
            }

        })
        binding.list.adapter = adapter
        viewModel.data.observe(viewLifecycleOwner) {state ->
            adapter.submitList(state.cards)

        }
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.getCard()
        }

        return binding.root
    }
}