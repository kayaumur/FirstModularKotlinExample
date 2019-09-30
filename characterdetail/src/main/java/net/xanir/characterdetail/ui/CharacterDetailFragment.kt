package net.xanir.characterdetail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import net.xanir.characterdetail.R
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
            fragmentCharacterDetailBinding.films.adapter = characterDetailAdapter
            characterDetailViewModel.name.observe(viewLifecycleOwner, Observer {
                fragmentCharacterDetailBinding.name.text = String.format(getString(R.string.name,it!!)) })
            characterDetailViewModel.birthYear.observe(viewLifecycleOwner, Observer {
                fragmentCharacterDetailBinding.birthYear.text = String.format(getString(R.string.birth_date,it!!)) })
            characterDetailViewModel.height.observe(viewLifecycleOwner, Observer {
                fragmentCharacterDetailBinding.height.text = String.format(getString(R.string.height,it!!)) })
            characterDetailViewModel.speciesName.observe(viewLifecycleOwner, Observer {
                fragmentCharacterDetailBinding.species.text = String.format(getString(R.string.species,it!!)) })
            characterDetailViewModel.language.observe(viewLifecycleOwner, Observer {
                fragmentCharacterDetailBinding.language.text = String.format(getString(R.string.language,it!!)) })
            characterDetailViewModel.homeWorld.observe(viewLifecycleOwner, Observer {
                fragmentCharacterDetailBinding.home.text = String.format(getString(R.string.homeWorld,it!!)) })
            characterDetailViewModel.population.observe(viewLifecycleOwner, Observer {
                fragmentCharacterDetailBinding.population.text = String.format(getString(R.string.population,it!!)) })
            characterDetailViewModel.film.observe(viewLifecycleOwner, Observer {
                characterDetailAdapter.setmItems(it!!) })
        }
    }
}