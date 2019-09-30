package net.xanir.characterdetail.data.remotes

import net.xanir.api.api.ApiServices


/**
 * Created by Umur Kaya on 29-Sep-19.
 */
class CharacterPlanetRemote(private val apiServices: ApiServices) {
    suspend fun getPlanet(id : String) = apiServices.getPlanet(id)
}