package net.xanir.characterlist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import net.xanir.api.model.ListOfPeople
import net.xanir.characterlist.data.CharacterListRemote
import net.xanir.characterlist.viewModel.CharacterListViewModel
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule


/**
 * Created by Umur Kaya on 30-Sep-19.
 */
class CharacterListViewModelTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    var characterListRemote : CharacterListRemote = mockk()
    var characterListViewModel = CharacterListViewModel(characterListRemote)

    @Before
    fun init(){
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @Test
    fun listSuccess() = runBlocking{
        val listOfPeople : ListOfPeople = mockk(null,relaxed = true)
        coEvery{ characterListRemote.getCharacterList() } returns listOfPeople
        val observer : Observer<ListOfPeople> = mockk(null,relaxed = true)
        characterListViewModel.peopleList.observeForever(observer)
        verify { observer.onChanged(listOfPeople) }
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }
}