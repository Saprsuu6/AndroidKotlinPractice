package com.example.lifecycleandlivedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import com.example.lifecycleandlivedata.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var lifeCycleObserver = DataOperations()
    private var myLiveData = MyLiveData()
    private var liveDataInt = MutableLiveData<Int>()
    private lateinit var observer: Observer<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observer = Observer { binding.testLiveData.text = it }
        binding.send.setOnClickListener {
            myLiveData.value = binding.textToLiveData.text.toString()

            // converting
            liveDataInt = Transformations.map(myLiveData) {
                Integer.parseInt(it)
            } as MutableLiveData<Int>
            println(liveDataInt.value)
        }

        lifecycle.addObserver(lifeCycleObserver)

        CoroutineScope(Dispatchers.IO).launch {
            binding.textToLiveData.setText("Hello from other thread")
            myLiveData.postValue(binding.textToLiveData.text.toString());
        }
    }

    override fun onStart() {
        super.onStart()
        myLiveData.observe(this, observer)
    }

    override fun onStop() {
        super.onStop()
        myLiveData.removeObserver(observer)
    }
}