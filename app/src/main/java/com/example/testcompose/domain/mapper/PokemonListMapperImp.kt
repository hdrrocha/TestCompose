package com.example.testcompose.domain.mapper


import com.example.testcompose.data.model.Pokemon
import com.example.testcompose.domain.mapper.abs.PokemonListMapper
import com.example.testcompose.domain.uimodel.PokemonUi

class PokemonListMapperImp: PokemonListMapper {
    override fun map(pokemons: List<Pokemon?>): MutableList<PokemonUi?> {
        val outPut: MutableList<PokemonUi?> = mutableListOf()
        if (pokemons != null) {
            for (pokemon in pokemons) {
                pokemon?.let {
                    outPut.add(
                        PokemonUi(
                            it.name,
                            it.url
                        )
                    )
                }

            }
        }
        return outPut
    }
}