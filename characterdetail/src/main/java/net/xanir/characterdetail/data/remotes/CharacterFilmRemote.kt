package net.xanir.characterdetail.data.remotes

import net.xanir.api.api.ApiServices


/**
 * Created by Umur Kaya on 29-Sep-19.
 */
class CharacterFilmRemote (private val apiServices: ApiServices){
    suspend fun getFilm(id : String) = apiServices.getFilm(id)
}