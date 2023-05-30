package com.example.thrones.presentation.characterList

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.thrones.data.remote.CharacterInfo
import com.example.thrones.ui.theme.Typography
import com.example.thrones.utils.Constants

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CharacterListScreen(
    characterListScreenState: CharacterListScreenState,
    cardClick: (id: Int) -> Unit
) {
    Scaffold(topBar ={ TopBar()} ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (characterListScreenState.isLoading){
                CircularProgressIndicator(modifier = Modifier.semantics {
                    contentDescription = Constants.IS_LOADING
                })
            }
            if (characterListScreenState.error != null){
                Text(text = characterListScreenState.error)
            }
            LazyVerticalGrid(columns =GridCells.Fixed(2) ,
                content = {
                    items(characterListScreenState.chars){charItem->
                        CharacterItem(charItem){
                            id ->  cardClick(id)
                        }
                    }
                })
        }
    }
}

@Composable
fun CharacterItem(person: CharacterInfo,cardClick:(id: Int)->Unit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(4.dp)
            .clickable { cardClick(person.id) }
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
            AsyncImage(
                model = person.imageUrl,
                contentDescription = "${person.firstName} image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(4.dp)
                    .clip(RoundedCornerShape(25))
                    .size(150.dp)

            )

            Text(text = person.fullName,
            style = Typography.h2,
            modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun TopBar() {
    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "GOT Characters",
        style = Typography.h2)
    }
}