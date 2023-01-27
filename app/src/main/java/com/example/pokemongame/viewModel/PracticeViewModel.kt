package com.example.pokemongame.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemongame.model.data.GetResultAPI
import com.example.pokemongame.model.data.PokemonResponse
import com.example.pokemongame.utils.RetrofitHelper
import kotlinx.coroutines.launch
import retrofit2.Response


class PracticeViewModel : ViewModel() {

    private val _pokemonResponse = MutableLiveData<Response<PokemonResponse>>()
    val pokemonResponse: LiveData<Response<PokemonResponse>>
        get() = _pokemonResponse


    fun getPokemons() {
        viewModelScope.launch {
            _pokemonResponse.value =
                RetrofitHelper.getRetrofit().create(GetResultAPI::class.java)
                    .getPokemons()

        }
    }

}

