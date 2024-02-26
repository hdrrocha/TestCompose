package com.example.testcompose.data.api

import com.example.testcompose.data.model.PokemonResponse
import com.example.testcompose.data.model.SinglePokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokemonApi {
    @GET("pokemon/")
    suspend fun fetchPokemon(
        @Query("limit") limit: Int = 100,
        @Query("offset") offset: Int = 200
    ): PokemonResponse

    @GET("pokemon/{name}/")
    suspend fun getSinglePokemon(
        @Path("name") name: String
    ): SinglePokemonResponse
}