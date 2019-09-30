package net.xanir.characterdetail.ui

import androidx.recyclerview.widget.RecyclerView
import net.xanir.api.model.Film
import net.xanir.characterdetail.R
import net.xanir.characterdetail.databinding.ListItemFilmBinding


/**
 * Created by Umur Kaya on 29-Sep-19.
 */
class CharacterFilmHolder internal constructor(internal val binding: ListItemFilmBinding) : RecyclerView.ViewHolder(binding.root){
    fun setData(film : Film){
        binding.openingCrawl.text = film.openingCrawl
        binding.title.text = String.format(binding.title.context!!.getString(R.string.film,film.title))
        binding.releaseDate.text = String.format(binding.releaseDate.context!!.getString(R.string.releaseDate,film.releaseDate))
    }
}