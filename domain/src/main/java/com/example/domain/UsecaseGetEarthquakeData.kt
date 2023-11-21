package com.example.domain

import com.example.data.model.EarthquakeDto
import com.example.data.repository.RemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UsecaseGetEarthquakeData(val repo: RemoteRepository) {

    fun getDemoData(): EarthquakeDto? {
        return repo.getDemoData()
    }

    fun getEarthquakes(startTime: String): EarthquakeDto? {
        return repo.getEarthquakes(startTime)
    }
}