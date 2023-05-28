package com.example.thrones.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.thrones.presentation.characterDetails.CharacterDetailScreen
import com.example.thrones.presentation.characterDetails.CharacterDetailsViewModel
import com.example.thrones.presentation.characterList.CharacterListScreen
import com.example.thrones.presentation.characterList.CharacterListViewModel

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(
        navController =navHostController,
        startDestination ="home"
    ){
        composable(route ="home" ){
            val vm : CharacterListViewModel = hiltViewModel()
            CharacterListScreen(characterListScreenState = vm.state.value){id->
                navHostController.navigate("home/$id")
            }
        }
        composable(
            route = "home/{id}",
            arguments = listOf(navArgument("id"){
                type = NavType.IntType
            })
        ){
            val vm : CharacterDetailsViewModel = hiltViewModel()
            CharacterDetailScreen(characterDetailScreenState = vm.state.value)
        }
    }
}