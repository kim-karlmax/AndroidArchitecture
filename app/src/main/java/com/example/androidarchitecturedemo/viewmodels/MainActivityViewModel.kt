package com.example.androidarchitecturedemo.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.UsecaseGetEarthquakeData
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainActivityViewModel : ViewModel(), KoinComponent {
    val usecase: UsecaseGetEarthquakeData by inject()

    init {
        fetchDemoData()
    }

    fun fetchDemoData() {
        viewModelScope.launch {
            usecase.getDemoData().collect { earthquakeDto ->
                earthquakeDto.features.forEach {
                    Log.d("&&", "&& $it")
                }
            }
        }
    }
}