package com.example.lifecycleandlivedata

import androidx.lifecycle.MutableLiveData

class MyLiveData : MutableLiveData<String>() {
    public override fun setValue(value: String?) {
        super.setValue(value)
    }

    public override fun postValue(value: String?) {
        super.postValue(value)
    }

    override fun getValue(): String? {
        return super.getValue()
    }

    override fun onActive() {
        super.onActive()
        // Connect to DB
    }

    override fun onInactive() {
        super.onInactive()
        // Disconnect from DB
    }
}