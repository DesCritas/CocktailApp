package com.descritas.cocktailapp.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.descritas.cocktailapp.R
import com.descritas.cocktailapp.adapter.ViewPagerAdapter
import com.descritas.cocktailapp.databinding.FragmentOnboardingBinding
import com.descritas.cocktailapp.model.CardModelState
import com.descritas.cocktailapp.viewModel.CardViewModel
import com.google.android.material.snackbar.Snackbar

class OnBoardingFragment : Fragment() {

    lateinit var binding: FragmentOnboardingBinding

    private val viewModel: CardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardingBinding.inflate(
            inflater,
            container,
            false
        )

        viewModel.state.observe(viewLifecycleOwner) { state ->
            if (state == CardModelState.Idle) {
                binding.tvNext.setOnClickListener {
                    findNavController().navigateUp()
                }
            }

            if (state == CardModelState.Error) {
                Snackbar.make(binding.root, R.string.error_loading, Snackbar.LENGTH_LONG)
                    .setAction(R.string.retry_loading) {
                        viewModel.refresh()
                    }.show()
            }
        }

        binding.viewPager2.adapter = ViewPagerAdapter()

        return binding.root
    }
}
