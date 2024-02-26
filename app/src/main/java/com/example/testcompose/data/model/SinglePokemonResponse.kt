package com.example.testcompose.data.model

data class SinglePokemonResponse(
    val base_experience: Double,
    val forms: List<Species>,
    val game_indices: List<GameIndex>,
    val height: Double,
    val held_items: List<Any?>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val name: String,
    val order: Int,
    val past_types: List<Any?>,
    val species: Species,
    val sprites: PokemonSprites,
    val types: List<PokemonTypes>,
    val weight: Double
)



