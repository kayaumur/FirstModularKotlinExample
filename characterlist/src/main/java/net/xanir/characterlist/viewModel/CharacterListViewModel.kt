package net.xanir.characterlist.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import net.xanir.characterlist.data.CharacterListRemote


/**
 * Created by Umur Kaya on 29-Sep-19.
 */
class CharacterListViewModel(private val characterListRemote: CharacterListRemote) : ViewModel() {
    val peopleList = liveData { Dispatchers.IO
        try{
            emit(characterListRemote.getCharacterList())
        }catch (e : Exception){
            //TODO Add no internet connection or retry option later
            e.printStackTrace()
        }
    }
}

