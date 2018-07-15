package com.joeli.transfer.model

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val isSubmitted = MutableLiveData<Boolean>()
}