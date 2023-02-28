package com.descritas.cocktailapp.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.descritas.cocktailapp.activity.OnBoardingFragment


class MyPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {


    override fun getItemCount() = 3

    override fun createFragment(position: Int) = OnBoardingFragment.newInstance(position)
}