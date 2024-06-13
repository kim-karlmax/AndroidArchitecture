package com.example.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.model.Feature

class EarthquakePagingSource(): PagingSource<Int, Feature>() {

    private val constOFFSET = 10
    override fun getRefreshKey(state: PagingState<Int, Feature>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(constOFFSET)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(constOFFSET)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Feature> {
        return try {
            val offset = params.key ?: 1
            val response = RemoteService.remoteApiInterface.getEarthquakeData(offset = offset)

            LoadResult.Page(
                data = response.features,
                prevKey = if (offset == 1) null else offset.minus(constOFFSET),
                nextKey = if (response.features.isEmpty()) null else offset.plus(constOFFSET),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
