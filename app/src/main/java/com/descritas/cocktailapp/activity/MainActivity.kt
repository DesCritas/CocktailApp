package com.descritas.cocktailapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.descritas.cocktailapp.R
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main)

    }
}