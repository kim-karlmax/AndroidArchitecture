package com.example.data.remote

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.model.Feature

class EarthquakePagingSource(): PagingSource<Int, Feature>() {
    private val constPageSize = 10

    override fun getRefreshKey(state: PagingState<Int, Feature>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Feature> {
        return try {
            val pageNum = params.key ?: 1
            val response = RemoteService.remoteApiInterface.getEarthquakeData(
                pageSize = constPageSize, offset = (pageNum-1) * constPageSize + 1)

            LoadResult.Page(
                data = response.features,
                prevKey = if (pageNum == 1) null else pageNum.minus(1),
                nextKey = if (response.features.isEmpty()) null else pageNum.plus(1),
            )
        } catch (e: Exception) {
            Log.e("myapp", e.message.toString())
            LoadResult.Error(e)
        }
    }
}
