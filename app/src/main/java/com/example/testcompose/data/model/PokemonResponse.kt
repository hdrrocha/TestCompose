package com.example.testcompose.data.model

import com.example.testcompose.data.model.Pokemon
import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("results") val pokemons: List<Pokemon>,
    @SerializedName("stat") val stat: String
)
