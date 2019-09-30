package net.xanir.characterlist.viewModel

import net.xanir.characterlist.data.CharacterListRemote
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 * Created by Umur Kaya on 29-Sep-19.
 */
val characterViewModelModule = module {
    viewModel { CharacterListViewModel(get()) }
    single { CharacterListRemote(get())}
}