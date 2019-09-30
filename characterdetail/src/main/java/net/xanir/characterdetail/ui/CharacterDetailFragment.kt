package net.xanir.characterdetail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import net.xanir.characterdetail.databinding.FragmentCharacterDetailBinding
import net.xanir.characterdetail.viewModel.CharacterDetailViewModel
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * Created by Umur Kaya on 29-Sep-19.
 */
class CharacterDetailFragment : Fragment() {

    private lateinit var fragmentCharacterDetailBinding : FragmentCharacterDetailBinding
    private val characterDetailViewModel : CharacterDetailViewModel by viewModel()
    private lateinit var characterDetailAdapter: CharacterDetailAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentCharacterDetailBinding = FragmentCharacterDetailBinding.inflate(inflater,container,false)
        return fragmentCharacterDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments!!.getString("id") != null) {
            characterDetailViewModel.getCharacter(arguments!!.getString("id")!!)
            characterDetailAdapter = CharacterDetailAdapter()
            fragmentCharacterDetailBinding.container.adapter = characterDetailAdapter
            characterDetailViewModel.others.observe(viewLifecycleOwner, Observer {
                characterDetailAdapter.setOtherItems(it!!)
            })
            characterDetailViewModel.film.observe(viewLifecycleOwner, Observer {
                characterDetailAdapter.setFilmList(it!!) })
        }
    }
}