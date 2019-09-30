package net.xanir.characterdetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import net.xanir.api.model.*
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
    fun check_postCharacterDependentData(){
        val people : People = mockk(null,relaxed = true)
        val observer : Observer<String> = mockk(null,relaxed = true)
        characterDetailViewModel.postCharacterDependentData(people)
        characterDetailViewModel.name.observeForever(observer)
        verify { observer.onChanged(people.name) }
    }

    @Test
    fun check_postSpeciesDependentData(){
        val species : Species = mockk(null,relaxed = true)
        val observer : Observer<String> = mockk(null,relaxed = true)
        characterDetailViewModel.postSpeciesDependentData(species)
        characterDetailViewModel.speciesName.observeForever(observer)
        verify { observer.onChanged(species.name) }
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        testThreadSurrogate.close()
    }
}
