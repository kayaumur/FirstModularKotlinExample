package net.xanir.api.model

/**
 * Created by Umur Kaya on 29-Sep-19.
 */
data class ListOfPeople(
    val count : Int?,
    val next : String?,
    val previous : String?,
    val results : ArrayList<People>?
)