package net.xanir.characterlist.ui

import android.net.Uri
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import net.xanir.api.model.People
import net.xanir.characterlist.R
import net.xanir.characterlist.databinding.ListItemCharacterListBinding


/**
 * Created by Umur Kaya on 29-Sep-19.
 */

class CharacterListHolder internal constructor(internal val binding: ListItemCharacterListBinding) : RecyclerView.ViewHolder(binding.root){
    fun setItem(people: People){
        binding.name.text = String.format(binding.name.context!!.getString(R.string.name), people.name)
        binding.birthYear.text = String.format(binding.birthYear.context!!.getString(R.string.birth_date), people.birthYear)
        binding.container.setOnClickListener{ view ->
            val bundle = Bundle()
            bundle.putString("id", Uri.parse((people.url)).lastPathSegment!!)
            view.findNavController().navigate(net.xanir.androidcommons.R.id.action_character_list_to_detail_fragment,bundle)
        }
    }
}