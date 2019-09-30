package net.xanir.characterlist.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import net.xanir.api.model.ListOfPeople
import net.xanir.api.model.People
import net.xanir.characterlist.R
import net.xanir.characterlist.databinding.ListItemCharacterListBinding


/**
 * Created by Umur Kaya on 29-Sep-19.
 */
class CharacterListAdapter : RecyclerView.Adapter<CharacterListHolder>() {

    private var mItems = arrayListOf<People>()
    private var context : Context? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.context = recyclerView.context
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        this.context = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListHolder {
        return CharacterListHolder(ListItemCharacterListBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CharacterListHolder, position: Int) {
        holder.setItem(mItems[position])
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun setItems(listOfPeople : ArrayList<People>){
        mItems = listOfPeople
        notifyDataSetChanged()
    }
}