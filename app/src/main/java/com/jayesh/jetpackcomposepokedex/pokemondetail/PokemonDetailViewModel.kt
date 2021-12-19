package com.jayesh.jetpackcomposepokedex.pokemondetail

import androidx.lifecycle.ViewModel
import com.jayesh.jetpackcomposepokedex.data.remote.responses.Pokemon
import com.jayesh.jetpackcomposepokedex.repository.PokemonRepository
import com.jayesh.jetpackcomposepokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    //异步函数
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}