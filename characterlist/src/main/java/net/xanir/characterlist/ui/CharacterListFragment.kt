package net.xanir.characterlist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import net.xanir.characterlist.databinding.FragmentCharacterListBinding
import net.xanir.characterlist.viewModel.CharacterListViewModel
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * Created by Umur Kaya on 29-Sep-19.
 */
class CharacterListFragment : Fragment() {

    private lateinit var characterListBinding : FragmentCharacterListBinding
    private val characterListViewModel : CharacterListViewModel by viewModel()
    private lateinit var characterListAdapter: CharacterListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        characterListBinding = FragmentCharacterListBinding.inflate(inflater,container,false)
        return characterListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        characterListAdapter = CharacterListAdapter()
        characterListBinding.characterList.adapter = characterListAdapter
        characterListViewModel.peopleList.observe(viewLifecycleOwner, Observer { characterListAdapter.setmItems(it!!) })
    }
}