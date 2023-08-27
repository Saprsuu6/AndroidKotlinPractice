package com.example.catsstatuseshandbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catsstatuseshandbook.databinding.ActivityMainBinding
import com.example.catsstatuseshandbook.models.StatusCat
import com.example.catsstatuseshandbook.models.StatusCodes

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val statusCodeAdapter = StatusCodeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            recycler.layoutManager = LinearLayoutManager(this@MainActivity)
            recycler.adapter = statusCodeAdapter

            for (statusCode in StatusCodes.codes) {
                statusCodeAdapter.addStatusCat(
                    StatusCat(
                        resources.getString(
                            R.string.url, statusCode
                        )
                    )
                )
            }

            codeStatus.doOnTextChanged { text, _, _, _ ->
                statusCodeAdapter.searchStatusCat(text.toString().trim(), applicationContext)
            }
        }
    }
}