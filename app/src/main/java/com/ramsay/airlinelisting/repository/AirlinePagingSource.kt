package com.ramsay.airlinelisting.repository

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ramsay.airlinelisting.di.Modules
import com.ramsay.airlinelisting.models.ApiClient
import com.ramsay.airlinelisting.models.response.Airline
import com.ramsay.airlinelisting.models.response.Data
import javax.inject.Inject

class AirlinePagingSource
    :PagingSource<Int,Data>() {


    private val apiClient: ApiClient = Modules.provideApi().create(ApiClient::class.java)
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {

        val pageNumber = params.key ?: 1
        val responseDTO = apiClient.getData(pageNumber,10)
        val airlineList: List<Data> = responseDTO.data
        Log.d("TAG", "load: $responseDTO")
        return try {
            LoadResult.Page(
                data = airlineList,
                prevKey = null,
                nextKey = if (airlineList.isEmpty()) null
                else pageNumber + 1
            )

        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition
    }


}