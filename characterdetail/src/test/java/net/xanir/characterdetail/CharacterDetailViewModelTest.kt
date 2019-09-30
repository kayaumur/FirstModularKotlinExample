package net.xanir.characterdetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import net.xanir.api.model.*
import net.xanir.characterdetail.data.model.CharacterListModel
import net.xanir.characterdetail.data.remotes.CharacterDetailRemote
import net.xanir.characterdetail.data.remotes.CharacterFilmRemote
import net.xanir.characterdetail.data.remotes.CharacterPlanetRemote
import net.xanir.characterdetail.data.remotes.CharacterSpeciesRemote
import net.xanir.characterdetail.viewModel.CharacterDetailViewModel
import org.junit.After
import org.junit.Test

import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule


class CharacterDetailViewModelTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    private val testThreadSurrogate = newSingleThreadContext("UI thread")

    private var characterDetailRemote : CharacterDetailRemote = mockk()
    private var characterPlanetRemote : CharacterPlanetRemote = mockk()
    private var characterFilmRemote : CharacterFilmRemote = mockk()
    private var characterSpeciesRemote : CharacterSpeciesRemote = mockk()
    private var characterDetailViewModel = CharacterDetailViewModel(characterDetailRemote,characterSpeciesRemote,characterFilmRemote,characterPlanetRemote)

    @Before
    fun init(){
        Dispatchers.setMain(testThreadSurrogate)
    }

    @Test
    fun check_postCharacterDependentData() = runBlocking {
        val people : People = mockk(null,relaxed = true)
        val observer : Observer<ArrayList<CharacterListModel>> = mockk(null,relaxed = true)
        characterDetailViewModel.postCharacterDependentData(people)
        characterDetailViewModel.others.observeForever(observer)
        verify { observer.onChanged(characterDetailViewModel.others.value) }
    }

    @Test
    fun check_postSpeciesDependentData() = runBlocking {
        val species : Species = mockk(null,relaxed = true)
        val observer : Observer<ArrayList<CharacterListModel>> = mockk(null,relaxed = true)
        characterDetailViewModel.postSpeciesDependentData(species)
        characterDetailViewModel.others.observeForever(observer)
        verify { observer.onChanged(characterDetailViewModel.others.value) }
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        testThreadSurrogate.close()
    }
}
