package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.data.model.EarthquakeDto
import com.example.data.remote.EarthquakePagingSource
import com.example.data.remote.RemoteService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository {
    fun getEarthquakeData() = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = { EarthquakePagingSource() }
    ).flow

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