package net.xanir.api.model


import com.google.gson.annotations.SerializedName

data class Species(
    @SerializedName("homeworld")
    val homeWorld: String?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("name")
    val name: String?
)