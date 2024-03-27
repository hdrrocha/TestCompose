package com.example.testcompose.domain.mapper.abs


import com.example.testcompose.data.model.Pokemon
import com.example.testcompose.domain.uimodel.PokemonUi

interface PokemonListMapper {
    fun map(pokemons: List<Pokemon?>): MutableList<PokemonUi?>
}
