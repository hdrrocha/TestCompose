package com.example.testcompose.domain.mapper.abs

import androidx.paging.PagingData
import com.example.testcompose.data.model.Pokemon
import com.example.testcompose.domain.uimodel.PokemonUi

interface PokemonListMapper {
    fun map(input: PagingData<Pokemon>): PagingData<PokemonUi>
}
