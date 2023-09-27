package com.mo.composeplayground.presentation.counter

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel : ViewModel() {
    private val _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()

    fun onIncreaseClicked(){
        _counter.update { it + 1 }
    }

    fun onDecreaseClicked(){
        _counter.update { it - 1 }
    }



}