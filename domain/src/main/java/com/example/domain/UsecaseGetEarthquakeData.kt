package com.example.domain

import com.example.data.model.EarthquakeDto
import com.example.data.repository.RemoteRepository

class UsecaseGetEarthquakeData(val repo: RemoteRepository) {
    fun getDemoData(): EarthquakeDto? {
        return repo.getDemoData()
    }

//    fun getDemoData(): EarthquakeDto? {
//        return repo.getDemoData()
//    }

    fun getEarthquakes(startTime: String): EarthquakeDto? {
        return repo.getEarthquakes(startTime)
    }
}