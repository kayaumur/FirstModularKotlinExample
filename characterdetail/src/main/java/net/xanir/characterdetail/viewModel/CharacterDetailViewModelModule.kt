package net.xanir.characterdetail.viewModel

import net.xanir.characterdetail.data.remotes.CharacterDetailRemote
import net.xanir.characterdetail.data.remotes.CharacterFilmRemote
import net.xanir.characterdetail.data.remotes.CharacterPlanetRemote
import net.xanir.characterdetail.data.remotes.CharacterSpeciesRemote
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 * Created by Umur Kaya on 29-Sep-19.
 */

val characterDetailViewModelModule = module {
    viewModel { CharacterDetailViewModel(get(),get(),get(),get()) }
    single { CharacterDetailRemote(get()) }
    single { CharacterFilmRemote(get()) }
    single { CharacterSpeciesRemote(get()) }
    single { CharacterPlanetRemote(get()) }
}