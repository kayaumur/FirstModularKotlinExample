package net.xanir.characterdetail.data

import net.xanir.api.api.ApiServices


/**
 * Created by Umur Kaya on 29-Sep-19.
 */
class CharacterSpeciesRemote (private val apiServices: ApiServices){
    suspend fun getSpecies(id : String) = apiServices.getSpecies(id)
}