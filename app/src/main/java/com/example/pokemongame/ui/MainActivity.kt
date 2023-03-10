package com.example.pokemongame.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokemongame.R
import com.example.pokemongame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //view binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}