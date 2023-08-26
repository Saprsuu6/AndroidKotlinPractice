package com.example.resultfromactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.resultfromactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val name = it.data?.getStringExtra("answer")
                binding.message.text = getString(R.string.greetings, name)
            } else {
                binding.message.text = getString(R.string.greetingsError)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.letName.setOnClickListener {
            val letNameIntent = Intent(this, LetName::class.java)
            letNameIntent.putExtra("question", binding.message.text)
            resultLauncher.launch(letNameIntent)
        }
    }
}