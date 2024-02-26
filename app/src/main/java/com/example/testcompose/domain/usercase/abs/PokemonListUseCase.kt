package com.example.testcompose.domain.usercase.abs

import androidx.paging.PagingData
import com.example.testcompose.domain.uimodel.PokemonUi
import kotlinx.coroutines.flow.Flow

interface PokemonListUseCase {
    fun fetchPokemon(): Flow<PagingData<PokemonUi>>
}