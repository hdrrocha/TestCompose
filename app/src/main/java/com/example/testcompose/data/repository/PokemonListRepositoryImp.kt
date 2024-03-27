package com.example.testcompose.data.repository

import com.example.testcompose.data.api.PokemonApi
import com.example.testcompose.data.model.Pokemon
import com.example.testcompose.data.model.PokemonResponse
import com.example.testcompose.domain.repository.PokemonListRepository

class PokemonListRepositoryImp(
    private val pokemonApi: PokemonApi
) : PokemonListRepository {
    override suspend fun fetchPokemon(): List<Pokemon> {
        return  pokemonApi.fetchPokemon(200,100).pokemons
    }

}
