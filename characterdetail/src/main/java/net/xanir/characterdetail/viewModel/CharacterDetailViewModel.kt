package net.xanir.characterdetail.viewModel

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.xanir.api.model.Film
import net.xanir.api.model.People
import net.xanir.api.model.Species

import net.xanir.characterdetail.data.CharacterDetailRemote
import net.xanir.characterdetail.data.CharacterFilmRemote
import net.xanir.characterdetail.data.CharacterPlanetRemote
import net.xanir.characterdetail.data.CharacterSpeciesRemote


/**
 * Created by Umur Kaya on 29-Sep-19.
 */
class CharacterDetailViewModel(private val characterDetailRemote: CharacterDetailRemote,private val speciesRemote: CharacterSpeciesRemote,
                               private val characterFilmRemote: CharacterFilmRemote,private val characterPlanetRemote: CharacterPlanetRemote) : ViewModel() {

    val name = MutableLiveData<String>()
    val birthYear = MutableLiveData<String>()
    val height = MutableLiveData<String>()
    val speciesName = MutableLiveData<String>()
    val language = MutableLiveData<String>()
    val homeWorld = MutableLiveData<String>()
    val population = MutableLiveData<String>()
    private val filmList = arrayListOf<Film>()
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
        name.postValue(character.name)
        birthYear.postValue(character.birthYear)
        height.postValue(character.height!!.toString())
    }

    private fun loadCharacterDependentDataRemote(character : People){
        getSpeciesDetail(character.species!![0])
        loadFilms(character.films!!)
        postPlanetPopulation(character.homeWorld!!)
    }

    private fun getSpeciesDetail(speciesUrl : String) =
        viewModelScope.launch {Dispatchers.IO
            try {
                postSpeciesDependentData(speciesRemote.getSpecies(parseLastPartOfUrlString(speciesUrl)))
            } catch (e: Exception) {
                //TODO Add no internet connection or retry option later
                e.printStackTrace()
            }
        }

    fun postSpeciesDependentData(species: Species){
        language.postValue(species.language)
        speciesName.postValue(species.name)
        homeWorld.postValue(species.name)
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
                population.postValue(characterPlanetRemote.getPlanet(parseLastPartOfUrlString(planetUrl)).population)
            } catch (e: Exception) {
                //TODO Add no internet connection or retry option later
                e.printStackTrace()
            }
        }

    private fun parseLastPartOfUrlString(url : String) : String{
        return Uri.parse(url).lastPathSegment!!
    }
}