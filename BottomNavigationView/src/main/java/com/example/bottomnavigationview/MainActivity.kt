package com.example.bottomnavigationview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bottomnavigationview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            navBottomMenu.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.home -> {
                        true
                    }

                    R.id.search -> {
                        true
                    }

                    R.id.add -> {
                        true
                    }

                    R.id.news -> {
                        true
                    }

                    R.id.page -> {
                        true
                    }

                    else -> false
                }
            }
        }
    }
}