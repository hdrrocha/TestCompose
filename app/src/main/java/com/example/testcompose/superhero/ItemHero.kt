package com.example.testcompose.superhero

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcompose.model.SuperHero

@Composable
fun ItemHero(superhero: SuperHero, onItemSelected:(SuperHero) -> Unit) {
    Card (border = BorderStroke(2.dp, Color.Gray), modifier = Modifier
        .width(200.dp)
        .clickable { onItemSelected(superhero) }) {
        Column {
            Image(
                painter = painterResource(id = superhero.photo),
                contentDescription = "Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Text(
                text = superhero.name,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 14.sp
            )
            Text(
                text = superhero.realName,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 10.sp
            )
            Text(
                text = superhero.publisher,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.align(Alignment.End).padding(end = 8.dp, bottom = 8.dp),
                fontSize = 12.sp
            )
        }
    }
}
