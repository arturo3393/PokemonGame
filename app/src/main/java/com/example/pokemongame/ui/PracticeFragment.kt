package com.example.pokemongame.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.pokemongame.R
import com.example.pokemongame.databinding.FragmentPracticeBinding
import com.example.pokemongame.viewModel.PracticeViewModel
import kotlin.random.Random

class PracticeFragment : Fragment(R.layout.fragment_practice) {

    private val practiceViewModel: PracticeViewModel by viewModels()


   private var _binding: FragmentPracticeBinding? = null

    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPracticeBinding.inflate(inflater,container,false)
        practiceViewModel.getPokemons()
        binding.btnPlayGame.setOnClickListener{

            practiceViewModel.pokemonResponse.observe(viewLifecycleOwner, Observer {
                val number = 0..904
                val pokemonPosition = number.random()
               val name= it.body()?.results?.get(pokemonPosition)?.name
                binding.tvPokemonName.text = name
                val url = it.body()?.results?.get(pokemonPosition)?.url
                binding.tvUrl.text=url
                Glide.with(requireContext())
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemonPosition+1}.png")
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.ivPokemonImg)
            })

        }

        return binding.root
    }

}