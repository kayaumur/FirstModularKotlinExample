package net.xanir.api.api

import retrofit2.http.GET
import retrofit2.http.Path
import net.xanir.api.model.*


/**
 * Created by Umur Kaya on 28-Sep-19.
 */
interface ApiServices {
    @GET("people/{id}")
    suspend fun getCharacter(@Path("id") id : String) : People

    @GET("people")
    suspend fun getCharacterList() : ListOfPeople

    @GET("films/{id}")
    suspend fun getFilm(@Path("id") id: String) : Film

    @GET("species/{id}")
    suspend fun getSpecies(@Path("id")id: String) : Species

    @GET("planets/{id}")
    suspend fun getPlanet(@Path("id")id: String) : Planet
}