package com.example.testcompose.domain.repository

import androidx.paging.PagingData
import com.example.testcompose.data.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonListRepository {
    fun fetchPokemon(): Flow<PagingData<Pokemon>>
}
