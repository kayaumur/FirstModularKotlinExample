package net.xanir.characterdetail.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.xanir.api.model.Film
import net.xanir.characterdetail.R
import net.xanir.characterdetail.databinding.ListItemFilmBinding


/**
 * Created by Umur Kaya on 29-Sep-19.
 */
class CharacterDetailAdapter : RecyclerView.Adapter<CharacterListHolder>() {

    var mItems = arrayListOf<Film>()
    private var context : Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListHolder {
        return CharacterListHolder(ListItemFilmBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        context = null
    }

    override fun onBindViewHolder(holder: CharacterListHolder, position: Int) {
        holder.binding.openingCrawl.text = mItems[position].openingCrawl
        holder.binding.title.text = String.format(context!!.getString(R.string.film,mItems[position].title))
        holder.binding.releaseDate.text = String.format(context!!.getString(R.string.releaseDate,mItems[position].releaseDate))
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun setmItems(arrayList: ArrayList<Film>){
        mItems = arrayList
        notifyDataSetChanged()
    }
}