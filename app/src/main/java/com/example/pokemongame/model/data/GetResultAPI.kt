package com.example.pokemongame.model.data

import retrofit2.Response
import retrofit2.http.GET


interface GetResultAPI {
    @GET("pokemon?limit=100000&offset=0")
    suspend fun getPokemons(): Response<PokemonResponse>
}
