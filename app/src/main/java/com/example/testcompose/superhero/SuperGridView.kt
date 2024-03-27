package com.example.testcompose.superhero


import PokemonListViewModel
import android.util.Log
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.testcompose.R
import com.example.testcompose.domain.uimodel.PokemonUi
import com.example.testcompose.model.SuperHero
import androidx.compose.runtime.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.testcompose.getPicUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

@Composable
fun SuperHeroGridView(viewModel: PokemonListViewModel) {
    // Carregar os dados ao iniciar o compositor
    LaunchedEffect(Unit) {
        viewModel.loadData()
    }

    // Observar a lista de Pokémon e o estado de carregamento
    var pokemonList by remember { mutableStateOf(emptyList<PokemonUi>()) }
    var isLoading by remember { mutableStateOf(true) }

    // Atualizar a lista de Pokémon e o estado de carregamento ao coletar o flow do ViewModel
    LaunchedEffect(viewModel) {
        viewModel.pokemonList.collect { list ->
            pokemonList = list ?: emptyList()
        }
    }
    LaunchedEffect(viewModel) {
        viewModel.loading.collect { loading ->
            isLoading = loading
        }
    }

    // Se estiver carregando, mostrar um indicador de progresso
    if (isLoading) {
        CircularProgressIndicator(modifier = Modifier.fillMaxSize())
    } else {
        // Se não estiver carregando, mostrar a lista de Pokémon
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(pokemonList) { pokemon ->
                // Renderizar cada item da lista de Pokémon
                ItemPokemon(pokemon = pokemon)
            }
        }
    }
}


@Composable
fun ItemPokemon(pokemon: PokemonUi) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        // Carregar a imagem do URL usand
        // o Glide
        GlideImage(url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/43.png")
        Text(text = pokemon.name)
        // Outras informações do pokemon podem ser exibidas aqui, como preço, classificação de usuário, etc.
    }
}

@Composable
fun GlideImage(url: String) {

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val imageBitmap = remember { mutableStateOf<ImageBitmap?>(null) }

    // Carregar a imagem usando Glide dentro do escopo de uma Coroutine
    LaunchedEffect(url) {
        coroutineScope.launch {
            try {
                val bitmap = withContext(Dispatchers.IO) {
                    Glide.with(context)
                        .asBitmap()
                        .load(url)
                        .placeholder(R.drawable.flash)
                        .error(R.drawable.flash) // Definir a imagem de erro
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .submit()
                        .get()
                }
                // Converter Bitmap para ImageBitmap
                imageBitmap.value = bitmap.asImageBitmap()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    // Exibir a imagem carregada
    imageBitmap.value?.let { img ->
        Image(
            bitmap = img,
            contentDescription = null,
            modifier = Modifier.size(100.dp) // Modificador de tamanho opcional
        )
    }
}
7w7