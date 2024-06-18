package com.example.domain

import com.example.data.model.EarthquakeDto
import com.example.data.repository.RemoteRepository

import kotlinx.coroutines.flow.flow

class UsecaseGetEarthquakeData(private val repo: RemoteRepository) {
    fun getEarthquakeData() = flow {
        repo.getEarthquakeData().collect {
            emit(it)
        }
    }

    fun getEarthquakes(startTime: String): EarthquakeDto? {
        return repo.getEarthquakes(startTime)
    }
}