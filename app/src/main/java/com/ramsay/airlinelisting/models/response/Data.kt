package com.ramsay.airlinelisting.models.response


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("airline")
    val airline: List<Airline>,
    @SerializedName("_id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("trips")
    val trips: Long,
    @SerializedName("__v")
    val v: Long
)