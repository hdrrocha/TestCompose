package com.example.testcompose.domain.usercase

import com.example.testcompose.domain.mapper.abs.PokemonListMapper
import com.example.testcompose.domain.repository.PokemonListRepository
import com.example.testcompose.domain.usercase.abs.PokemonListUseCase

import kotlinx.coroutines.flow.map

class PokemonListUseCaseImp(
    private val pokemonListRepository: PokemonListRepository,
    private val mapper: PokemonListMapper
) : PokemonListUseCase {
    override fun fetchPokemon() = pokemonListRepository.fetchPokemon().map { mapper.map(it) }
}

