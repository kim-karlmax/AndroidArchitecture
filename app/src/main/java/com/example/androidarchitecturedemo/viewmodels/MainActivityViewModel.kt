package com.example.androidarchitecturedemo.viewmodels

import androidx.lifecycle.ViewModel
import com.example.data.model.EarthquakeDto
import com.example.domain.UsecaseGetEarthquakeData
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainActivityViewModel : ViewModel(), KoinComponent {
    val usecase: UsecaseGetEarthquakeData by inject()

    fun usecaseGetDemoData(): EarthquakeDto? {
        usecase.getDemoData()?.let {
            return it
        }
        return null
    }
}