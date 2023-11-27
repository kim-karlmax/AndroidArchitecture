package com.example.data.repository

import com.example.data.model.EarthquakeDto
import com.example.data.remote.RemoteService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository {

    fun getDemoData(): EarthquakeDto? {
        val resp = RemoteService.remoteApiInterface.getDemoData().execute()
        return if (resp.isSuccessful) {
            resp.body()
        } else {
            null
        }
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