package com.example.lifecycleandlivedata

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class DataOperations : DefaultLifecycleObserver {
    override fun onResume(owner: LifecycleOwner) {
        super.onCreate(owner)
        println("load data")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        println("save data")
    }
}