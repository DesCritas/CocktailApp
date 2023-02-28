package com.descritas.cocktailapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.descritas.cocktailapp.adapter.MyPagerAdapter
import com.descritas.cocktailapp.databinding.ActivityOnboardingBinding


class PagerActivity : AppCompatActivity(){

    private var binding: ActivityOnboardingBinding? = null

    //lateinit var pager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val pagerOnBoarding = binding?.viewPager
        val adapter = MyPagerAdapter(this)
        pagerOnBoarding?.adapter = adapter
    }
}