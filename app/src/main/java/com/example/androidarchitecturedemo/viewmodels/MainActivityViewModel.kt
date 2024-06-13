package com.example.androidarchitecturedemo.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.data.model.Feature
import com.example.domain.UsecaseGetEarthquakeData
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainActivityViewModel : ViewModel(), KoinComponent {
    val usecase: UsecaseGetEarthquakeData by inject()

    private val _earthquakeDataState = mutableStateOf<List<Feature>>(emptyList())
    val earthquakeDataState: State<List<Feature>> = _earthquakeDataState

    init {
//        viewModelScope.launch {
//            fetchEarthquakeData()
//        }
    }

//    fun fetchEarthquakeData() {
//        viewModelScope.launch {
//            usecase.getEarthquakeData().collect { listFeatures ->
//                _earthquakeDataState.value = listFeatures as List<Feature>
//            }
//        }
//    }

    fun fetchEarthquakeData(): Flow<PagingData<Feature>> = usecase.getEarthquakeData().cachedIn(viewModelScope)
}