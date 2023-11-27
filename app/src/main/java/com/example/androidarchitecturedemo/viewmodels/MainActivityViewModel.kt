package com.example.androidarchitecturedemo.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.UsecaseGetEarthquakeData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainActivityViewModel : ViewModel(), KoinComponent {
    val usecase: UsecaseGetEarthquakeData by inject()

    fun usecaseGetDemoData() {
        viewModelScope.launch(Dispatchers.IO) {
            usecase.getDemoData()?.let { dto ->
                dto.features.forEach { feature ->
                    Log.d("&&", "&& $feature")
                }
            }
        }
    }
}