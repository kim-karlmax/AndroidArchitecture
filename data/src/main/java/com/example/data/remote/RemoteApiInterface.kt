package com.example.data.remote

import com.example.data.model.EarthquakeDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteApiInterface {
    /* earthquake query api examples
    @GET("fdsnws/event/1/query?format=geojson&starttime=2022-01-01&endtime=2023-01-01&minmag=6.5")
    @GET("fdsnws/event/1/query?format=geojson&minmag=6.0")
     */

    @GET("fdsnws/event/1/query?format=geojson&orderby=time")
    suspend fun getEarthquakeData(@Query("limit") pageSize: Int, @Query("offset") offset: Int): EarthquakeDto

    @GET("fdsnws/event/1/query?format=geojson&minmag=4")
    fun getEarthquakes(@Query("starttime") startTime: String): Call<EarthquakeDto>
}