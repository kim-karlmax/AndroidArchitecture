package com.example.data.remote

import com.example.data.model.EarthquakeDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteApiInterface {
    @GET("fdsnws/event/1/query?format=geojson&starttime=2022-01-01&endtime=2023-01-01&minmag=6")
    suspend fun getDemoData(): EarthquakeDto

    @GET("fdsnws/event/1/query?format=geojson&minmag=4")
    fun getEarthquakes(@Query("starttime") startTime: String): Call<EarthquakeDto>
}