package com.example.pokemongame.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavGraphNavigator
import androidx.navigation.findNavController
import com.example.pokemongame.R
import com.example.pokemongame.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    private var _binding: FragmentWelcomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)

        binding.btnPractice.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_global_practiceFragment)
        }

        return binding.root
    }

}