package com.example.testcompose.domain.mapper

import androidx.paging.PagingData
import androidx.paging.map
import com.example.testcompose.data.model.Pokemon
import com.example.testcompose.domain.mapper.abs.PokemonListMapper
import com.example.testcompose.domain.uimodel.PokemonUi

class PokemonListMapperImp : PokemonListMapper {
    override fun map(pokemon: PagingData<Pokemon>) = pokemon.map { pokemon ->
        PokemonUi(
            name = pokemon.name,
            urlId = pokemon.url
        )
    }
}