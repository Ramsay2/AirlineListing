package com.ramsay.airlinelisting.models.response


import com.google.gson.annotations.SerializedName

data class AirlineInfoDTO(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("totalPages")
    val totalPages: Int,
    @SerializedName("totalPassengers")
    val totalPassengers: Int
)