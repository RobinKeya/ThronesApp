package com.example.thrones.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.thrones.presentation.characterList.CharacterListScreen
import com.example.thrones.presentation.characterList.CharacterListViewModel
import com.example.thrones.ui.theme.ThronesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThronesTheme {
                val navController = rememberNavController()
                Navigation(navHostController =navController )
//                val vm: CharacterListViewModel = viewModel()
//                CharacterListScreen(characterListScreenState = vm.state.value ){id ->
//                    Log.d("$id","$id")
//                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ThronesTheme {
    }
}