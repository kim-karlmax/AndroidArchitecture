package com.example.androidarchitecturedemo.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.Feature
import com.example.domain.UsecaseGetEarthquakeData
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.scope.emptyState
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainActivityViewModel : ViewModel(), KoinComponent {
    val usecase: UsecaseGetEarthquakeData by inject()

    private val _earthquakeDataState = mutableStateOf<List<Feature>>(emptyList())
    val earthquakeDataState: State<List<Feature>> = _earthquakeDataState

    init {
        fetchDemoData()
    }

    fun fetchDemoData() {
        viewModelScope.launch {
            usecase.getDemoData().collect { earthquakeDto ->
                _earthquakeDataState.value = earthquakeDto.features
            }
        }
    }
}