package com.example.starWars.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.starWars.screens.main.MainScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
    ) {padding ->
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            navController = navController,
            startDestination = Screens.MainScreen.screenRoute
        ){
            composable(route = Screens.MainScreen.screenRoute){
                MainScreen(modifier = Modifier.fillMaxSize())
            }
        }

    }
}


sealed class Screens(
    val screenRoute: String
){


    object MainScreen: Screens(
        screenRoute = mainScreenRoute,
    ){
        fun destination(): String {
            return mainScreenRoute
        }
    }




    companion object{
        const val mainScreenRoute  = "mainScreen"
    }
}