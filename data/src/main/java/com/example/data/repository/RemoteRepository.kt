package com.example.data.repository

import com.example.data.model.EarthquakeDto
import com.example.data.remote.RemoteService
import kotlinx.coroutines.flow.flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository {

    suspend fun getDemoData() = flow {
        emit(RemoteService.remoteApiInterface.getDemoData())
    }

    //    fun getDemoData(): EarthquakeDto? {
//        var resp: EarthquakeDto? = null
//        RemoteService.remoteApiInterface.getDemoData()
//            .enqueue(object : Callback<EarthquakeDto> {
//                override fun onResponse(
//                    call: Call<EarthquakeDto>,
//                    response: Response<EarthquakeDto>
//                ) {
//                    resp = response.body()
//                }
//
//                override fun onFailure(call: Call<EarthquakeDto>, t: Throwable) {
//                }
//            })
//
//        return resp
//    }


    fun getEarthquakes(startTime: String): EarthquakeDto? {
        var resp: EarthquakeDto? = null

        RemoteService.remoteApiInterface.getEarthquakes(startTime)
            .enqueue(object : Callback<EarthquakeDto> {
                override fun onResponse(
                    call: Call<EarthquakeDto>,
                    response: Response<EarthquakeDto>
                ) {
                    resp = response.body()
                }

                override fun onFailure(call: Call<EarthquakeDto>, t: Throwable) {
                }
            })

        return resp
    }
}