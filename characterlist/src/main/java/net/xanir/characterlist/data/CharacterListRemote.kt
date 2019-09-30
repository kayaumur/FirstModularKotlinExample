package net.xanir.characterlist.data

import net.xanir.api.api.ApiServices


/**
 * Created by Umur Kaya on 29-Sep-19.
 */
class CharacterListRemote(private val apiServices: ApiServices) {
    suspend fun getCharacterList() = apiServices.getCharacterList()
}