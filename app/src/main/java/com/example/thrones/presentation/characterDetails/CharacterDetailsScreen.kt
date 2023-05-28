package com.example.thrones.presentation.characterDetails

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.thrones.ui.theme.Typography

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CharacterDetailScreen(characterDetailScreenState: CharacterDetailScreenState) {
        Scaffold(topBar = { TopBar()}) {
            if (characterDetailScreenState.characterInfo !=null){
                
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                ) {
                    AsyncImage(
                        model =characterDetailScreenState.characterInfo?.imageUrl,
                        contentDescription =characterDetailScreenState.characterInfo?.fullName,
                        modifier = Modifier
                            .clip(RoundedCornerShape(25))
                            .padding(8.dp)
                            .height(300.dp),
                        contentScale = ContentScale.Crop,
                    )
                    Text(
                        text = "Title: ${characterDetailScreenState.characterInfo.title}",
                        modifier = Modifier.padding(8.dp),
                        style = Typography.body1
                    )
                    Text(text = "Name : ${characterDetailScreenState.characterInfo.fullName}",
                            modifier = Modifier.padding(8.dp),
                        style = Typography.body1
                    )
                    Text(text = "Family ${characterDetailScreenState.characterInfo.family}",
                        modifier = Modifier.padding(8.dp),
                    style = Typography.body1)

                }
            }
        }
}

@Composable
fun TopBar() {
    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
        Text(text = "Character Details",
        style = Typography.h2
        )
    }
    
}