package com.example.androidarchitecturedemo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.data.model.Feature
import com.example.domain.UsecaseGetEarthquakeData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainActivityViewModel : ViewModel(), KoinComponent {
    val usecase: UsecaseGetEarthquakeData by inject()

//    private val _earthquakeDataState = mutableStateOf<List<Feature>>(emptyList())
//    val earthquakeDataState: State<List<Feature>> = _earthquakeDataState

    private val _earthquakeState: MutableStateFlow<PagingData<Feature>> = MutableStateFlow(value = PagingData.empty())
    val earthquakeState: MutableStateFlow<PagingData<Feature>> get() = _earthquakeState


    init {
        viewModelScope.launch {
            fetchEarthquakeData()
        }
    }

    private suspend fun fetchEarthquakeData() {
        usecase.getEarthquakeData().cachedIn(viewModelScope).collect {
            _earthquakeState.value = it
        }
    }
}