package net.xanir.characterdetail.data

import net.xanir.api.api.ApiServices


/**
 * Created by Umur Kaya on 29-Sep-19.
 */
class CharacterFilmRemote (private val apiServices: ApiServices){
    suspend fun getFilm(id : String) = apiServices.getFilm(id)
}