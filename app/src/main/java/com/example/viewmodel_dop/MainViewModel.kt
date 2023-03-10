package com.example.viewmodel_dop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _number = MutableLiveData<Int>()
    var number: LiveData<Int> = _number
    private var backgroundColor = "#FF000000"
    var count = 0


    fun setMinus() {
        count--
        _number.value = count
    }

    fun setPlus() {
        count++
        _number.value = count
        if (count == 10) {
            backgroundColor = "#FF1ED300"
        }
    }
}
