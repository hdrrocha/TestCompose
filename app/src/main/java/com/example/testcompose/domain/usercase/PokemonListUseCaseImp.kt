package com.example.testcompose.domain.usercase

import com.example.testcompose.domain.mapper.abs.PokemonListMapper
import com.example.testcompose.domain.repository.PokemonListRepository
import com.example.testcompose.domain.uimodel.PokemonUi
import com.example.testcompose.domain.usercase.abs.PokemonListUseCase

class PokemonListUseCaseImp(
    private val pokemonListRepository: PokemonListRepository,
    private val mapper: PokemonListMapper
) : PokemonListUseCase {
    override suspend fun fetchPokemons() = mapper.map(
         pokemonListRepository.fetchPokemon()
    )
}

