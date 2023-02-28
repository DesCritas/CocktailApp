package com.descritas.cocktailapp.activity


import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.descritas.cocktailapp.R
import com.descritas.cocktailapp.databinding.FragmentOnboardingBinding
import com.descritas.cocktailapp.model.CardModelState
import com.descritas.cocktailapp.util.StringArg
import com.descritas.cocktailapp.viewModel.CardViewModel
import com.google.android.material.snackbar.Snackbar


class OnBoardingFragment : Fragment() {

    lateinit var binding: FragmentOnboardingBinding


    private val viewModel: CardViewModel by activityViewModels()
    //var curPos: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
                    }
                    .show()
            }
        }
        /*when (curPos) {
            1 ->  binding.tvName.text = "One1"
            2 ->  binding.tvName.text = "Two2"
            3 ->  binding.tvName.text = "Three3"
            else -> { // Note the block
                print("x is neither 1 nor 2")
            }
        }*/

        val pos = arguments?.getInt(POSITION_ARG)
        val viewPager = binding.tvName
        pos?.let {
            when(pos){
                0 -> viewPager.text = "1"
                1 -> viewPager.text = "2"
                2 -> viewPager.text = "3"
            }
        }


        return binding.root
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val pos = arguments?.getInt(POSITION_ARG)
        val viewPager = binding.tvName
        pos?.let {
            when(pos){
                0 -> viewPager.text = "1"
                1 -> viewPager.text = "2"
                2 -> viewPager.text = "3"
            }
        }
    }*/
    companion object {
        var POSITION_ARG = "position_arg"
        @JvmStatic
        fun newInstance(position: Int) = OnBoardingFragment().apply {
            arguments = Bundle().apply {
                putInt(POSITION_ARG, position)
            }
        }
    }


}