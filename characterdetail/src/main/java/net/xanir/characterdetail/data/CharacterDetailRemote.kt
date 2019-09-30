package net.xanir.characterdetail.data

import net.xanir.api.api.ApiServices


/**
 * Created by Umur Kaya on 29-Sep-19.
 */
class CharacterDetailRemote(private val apiServices: ApiServices) {
    suspend fun getCharacter(id : String) = apiServices.getCharacter(id)
}