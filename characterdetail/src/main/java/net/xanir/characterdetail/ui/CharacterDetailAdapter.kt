package net.xanir.characterdetail.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.xanir.api.model.Film
import net.xanir.characterdetail.data.model.CharacterListModel
import net.xanir.characterdetail.databinding.ListItemFilmBinding
import net.xanir.characterdetail.databinding.ListItemListBinding


/**
 * Created by Umur Kaya on 29-Sep-19.
 */
class CharacterDetailAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var filmList = arrayListOf<Film>()
    private var otherItems = arrayListOf<CharacterListModel>()
    private var context : Context? = null

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position) == 1){
            val mHolder : CharacterListHolder = holder as CharacterListHolder
            mHolder.setData(otherItems[position])
            mHolder.binding.executePendingBindings()
        }
        else{
            val mHolder : CharacterFilmHolder = holder as CharacterFilmHolder
            mHolder.setData(filmList[position - otherItems.size])
            mHolder.binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == 1){
            return CharacterListHolder(ListItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }
        return CharacterFilmHolder(ListItemFilmBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        context = null
    }

    override fun getItemViewType(position: Int): Int {
        if(filmList.size == 0){
            return 1
        }
        else if(otherItems.size == 0){
            return 2
        }
        else{
            if(position < otherItems.size){
                return 1
            }
            return 2
        }
    }

    override fun getItemCount(): Int {
        return filmList.size + otherItems.size
    }

    fun setOtherItems(arrayList: ArrayList<CharacterListModel>){
        otherItems = arrayList
        notifyDataSetChanged()
    }

    fun setFilmList(arrayList: ArrayList<Film>){
        filmList = arrayList
        notifyDataSetChanged()
    }
}