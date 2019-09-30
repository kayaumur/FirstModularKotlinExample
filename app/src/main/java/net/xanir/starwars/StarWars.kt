package net.xanir.starwars

import android.app.Application
import net.xanir.api.di.apiModule
import net.xanir.characterdetail.viewModel.characterDetailViewModelModule
import net.xanir.characterlist.viewModel.characterViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


/**
 * Created by Umur Kaya on 28-Sep-19.
 */
class StarWars : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@StarWars)
            modules(listOf(apiModule, characterViewModelModule,characterDetailViewModelModule))
        }
    }
}