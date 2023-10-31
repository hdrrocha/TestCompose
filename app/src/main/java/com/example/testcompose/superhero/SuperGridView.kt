package com.example.testcompose.superhero

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcompose.R
import com.example.testcompose.model.SuperHero


@Preview(showBackground = true)
@Composable
fun SuperHeroGridView() {
    val selectedSuperHero = remember { mutableStateOf<SuperHero?>(null) }

    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(getSuperHeroes()) { superhero ->
            ItemHero(superhero = superhero) {
                selectedSuperHero.value = superhero
            }
        }
    }

    selectedSuperHero.value?.let { superhero ->
        ShowHeroDialog(superhero = superhero) {
            selectedSuperHero.value = null
        }
    }
}

@Composable
fun ShowHeroDialog(superhero: SuperHero?, onDismiss: () -> Unit) {
    superhero?.let { hero ->
        AlertDialog(
            onDismissRequest = {
                onDismiss()
            },
            title = {
                Text(text = hero.name)
            },
            text = {
                Column {
                    Image(
                        painter = painterResource(id = hero.photo),
                        contentDescription = "Avatar",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = "Real name: ${hero.realName}")
                    Text(text = "Publishing: ${hero.publisher}")
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        onDismiss()
                    }
                ) {
                    Text("OK")
                }
            }
        )
    }
}



fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Wolverine", "Logan", "Marvel", R.drawable.logan),
        SuperHero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        SuperHero("Thor", "Thor Odin", "Marvel", R.drawable.thor),
        SuperHero("Flash", "Jay Garrinck", "DC", R.drawable.flash),
        SuperHero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
        SuperHero("Wonder Woaman", "Princess Diana", "DC", R.drawable.wonder_woman),
    )
}