package net.xanir.characterdetail.ui

import androidx.recyclerview.widget.RecyclerView
import net.xanir.characterdetail.data.model.CharacterListModel
import net.xanir.characterdetail.databinding.ListItemListBinding


/**
 * Created by Umur Kaya on 30-Sep-19.
 */
class CharacterListHolder internal constructor(internal val binding:ListItemListBinding) : RecyclerView.ViewHolder(binding.root) {
    fun setData(characterListModel: CharacterListModel){
        if(characterListModel.formattedId != null){
            binding.listItem.text = String.format(binding.listItem.context.getString(characterListModel.formattedId),characterListModel.originalString)
        }
        else{
            binding.listItem.text = characterListModel.originalString
        }
    }
}