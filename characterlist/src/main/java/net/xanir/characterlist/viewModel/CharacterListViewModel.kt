package net.xanir.characterlist.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.xanir.api.model.ListOfPeople
import net.xanir.characterlist.data.CharacterListRemote


/**
 * Created by Umur Kaya on 29-Sep-19.
 */
class CharacterListViewModel(private val characterListRemote: CharacterListRemote) : ViewModel() {
    val peopleList = MutableLiveData<ListOfPeople>()

    fun getPeopleList() = viewModelScope.launch { Dispatchers.IO
        try{
            peopleList.postValue(characterListRemote.getCharacterList())
        }catch (e : Exception){
            //TODO Add no internet connection or retry option later
            e.printStackTrace()
        }
    }
}

