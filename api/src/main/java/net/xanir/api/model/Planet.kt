package net.xanir.api.model


import com.google.gson.annotations.SerializedName

data class Planet(
    @SerializedName("population")
    val population: String?
)