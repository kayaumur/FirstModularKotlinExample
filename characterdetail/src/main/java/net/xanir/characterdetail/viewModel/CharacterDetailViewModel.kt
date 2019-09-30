package net.xanir.characterdetail.viewModel

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.xanir.api.model.Film
import net.xanir.api.model.People
import net.xanir.api.model.Planet
import net.xanir.api.model.Species
import net.xanir.characterdetail.R
import net.xanir.characterdetail.data.model.CharacterListModel

import net.xanir.characterdetail.data.remotes.CharacterDetailRemote
import net.xanir.characterdetail.data.remotes.CharacterFilmRemote
import net.xanir.characterdetail.data.remotes.CharacterPlanetRemote
import net.xanir.characterdetail.data.remotes.CharacterSpeciesRemote


/**
 * Created by Umur Kaya on 29-Sep-19.
 */
class CharacterDetailViewModel(private val characterDetailRemote: CharacterDetailRemote, private val speciesRemote: CharacterSpeciesRemote,
                               private val characterFilmRemote: CharacterFilmRemote, private val characterPlanetRemote: CharacterPlanetRemote
) : ViewModel() {

    private val otherList = arrayListOf<CharacterListModel>()
    private val filmList = arrayListOf<Film>()
    val others = MutableLiveData<ArrayList<CharacterListModel>>()
    val film = MutableLiveData<ArrayList<Film>>()


    fun getCharacter(id : String) =
        viewModelScope.launch {Dispatchers.IO
            try {
                val character = characterDetailRemote.getCharacter(id)
                postCharacterDependentData(character)
                loadCharacterDependentDataRemote(character)
            } catch (e: Exception) {
                //TODO Add no internet connection or retry option later
                e.printStackTrace()
            }
        }

    fun postCharacterDependentData(character: People){
        otherList.add(CharacterListModel(R.string.name,character.name!!))
        otherList.add(CharacterListModel(R.string.birth_date,character.birthYear!!))
        otherList.add(CharacterListModel(R.string.height,character.height!!.toString()))
        others.postValue(otherList)
    }

    private fun getHomeWorldDetail(homeWorldUrl : String) =
        viewModelScope.launch {Dispatchers.IO
            try{
                postHomeWorldData(characterPlanetRemote.getPlanet(parseLastPartOfUrlString(homeWorldUrl)))
            }catch (e : Exception){
                //TODO Add no internet connection or retry option later
                e.printStackTrace()
            }
        }

    private fun loadCharacterDependentDataRemote(character : People){
        getSpeciesDetail(character.species!![0])
        loadFilms(character.films!!)
        postPlanetPopulation(character.homeWorld!!)
    }
    private fun postHomeWorldData(planet: Planet){
        otherList.add(CharacterListModel(R.string.homeWorld,planet.name!!))
        others.postValue(otherList)
    }

    private fun getSpeciesDetail(speciesUrl : String) =
        viewModelScope.launch {Dispatchers.IO
            try {
                val species = speciesRemote.getSpecies(parseLastPartOfUrlString(speciesUrl))
                postSpeciesDependentData(species)
                getHomeWorldDetail(species.homeWorld!!)
            } catch (e: Exception) {
                //TODO Add no internet connection or retry option later
                e.printStackTrace()
            }
        }

    fun postSpeciesDependentData(species: Species){
        otherList.add(CharacterListModel(R.string.language,species.language!!))
        otherList.add(CharacterListModel(R.string.species,species.name!!))
        others.postValue(otherList)
    }

    private fun loadFilms(filmUrl : ArrayList<String>) =
        filmUrl.forEach {
            viewModelScope.launch {Dispatchers.IO
                try {
                    filmList.add(characterFilmRemote.getFilm(parseLastPartOfUrlString(it)))
                    //filmList.sortByDescending { filmItem -> filmItem.releaseDate }
                    film.postValue(filmList)
                } catch (e: Exception) {
                    //TODO Add no internet connection or retry option later
                    e.printStackTrace()
                }
            }
        }


    private fun postPlanetPopulation(planetUrl : String) =
        viewModelScope.launch {Dispatchers.IO
            try {
                otherList.add(CharacterListModel(R.string.population,characterPlanetRemote.getPlanet(parseLastPartOfUrlString(planetUrl)).population!!))
                others.postValue(otherList)
            } catch (e: Exception) {
                //TODO Add no internet connection or retry option later
                e.printStackTrace()
            }
        }

    private fun parseLastPartOfUrlString(url : String) : String{
        return Uri.parse(url).lastPathSegment!!
    }
}