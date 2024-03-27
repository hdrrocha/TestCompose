package com.example.testcompose.domain.usercase.abs

import com.example.testcompose.domain.uimodel.PokemonUi
import kotlinx.coroutines.flow.Flow

interface PokemonListUseCase {
    suspend fun fetchPokemons(): MutableList<PokemonUi?>
}