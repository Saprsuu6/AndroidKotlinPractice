package com.example.resultfromactivity

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.resultfromactivity.databinding.ActivityLetNameBinding

class LetName : AppCompatActivity() {
    private lateinit var binding: ActivityLetNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLetNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val question = intent.getStringExtra("question")
        binding.message.text = question

        binding.back.setOnClickListener {
            if (binding.editName.text.toString().trim() == "") {
                setResult(Activity.RESULT_CANCELED, intent)
            } else {
                intent.putExtra("answer", binding.editName.text.toString().trim())
                setResult(Activity.RESULT_OK, intent)
            }

            finish()
        }
    }
}