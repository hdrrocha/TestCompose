package com.example.testcompose.domain.repository


import com.example.testcompose.data.model.Pokemon
import com.example.testcompose.data.model.PokemonResponse
import kotlinx.coroutines.flow.Flow

interface PokemonListRepository {
    suspend fun fetchPokemon(): List<Pokemon>
}
