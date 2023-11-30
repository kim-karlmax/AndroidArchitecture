package com.example.domain

import com.example.data.model.EarthquakeDto
import com.example.data.repository.RemoteRepository
import kotlinx.coroutines.flow.flow

class UsecaseGetEarthquakeData(private val repo: RemoteRepository) {
    suspend fun getDemoData() = flow {
        repo.getDemoData().collect {
            emit(it)
        }
    }

//    fun getDemoData(): EarthquakeDto? {
//        return repo.getDemoData()
//    }

    fun getEarthquakes(startTime: String): EarthquakeDto? {
        return repo.getEarthquakes(startTime)
    }
}