package net.xanir.api.model

import com.google.gson.annotations.SerializedName


/**
 * Created by Umur Kaya on 28-Sep-19.
 */
data class People (
    val name : String?,
    val height : Int?,
    @SerializedName("birth_year") val birthYear : String?,
    val gender : String?,
    @SerializedName("homeworld") val homeWorld : String?,
    val films : ArrayList<String>?,
    val species : ArrayList<String>?,
    val url : String?
)