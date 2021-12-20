package com.ramsay.airlinelisting.models

import com.ramsay.airlinelisting.models.response.Airline
import com.ramsay.airlinelisting.models.response.AirlineInfoDTO
import com.ramsay.airlinelisting.models.response.Data
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("/v1/passenger")
    suspend fun getData(
        @Query("page")page :Int,
        @Query("size")size:Int
    ):AirlineInfoDTO
}