package com.example.starWars.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.starWars.navigation.Screens.Companion.NAME_KEY
import com.example.starWars.screens.main.MainScreen
import com.example.starWars.screens.people.PeopleScreen


@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
    ) { padding ->
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            navController = navController,
            startDestination = Screens.MainScreen.destination()
        ) {

            composable(route = Screens.MainScreen.destination()) {
                MainScreen(modifier = Modifier.fillMaxSize(),
                    navigateToPeople = { navController.navigate(Screens.PeopleScreen.destination(it)) }
                )
            }

            composable(
                route = Screens.PeopleScreen.screenRoute,
                arguments = listOf(navArgument(NAME_KEY) {
                    type = NavType.StringType
                    nullable = false
                })
            ) { navBackStackEntry ->
                val name = navBackStackEntry.arguments?.getString(NAME_KEY).toString()
                PeopleScreen(
                    name = name,
                    onBack = navController::popBackStack,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}


sealed class Screens(
    val screenRoute: String
) {


    object MainScreen : Screens(
        screenRoute = mainScreenRoute,
    ) {
        fun destination(): String {
            return screenRoute
        }
    }

    object PeopleScreen : Screens(
        screenRoute = "$peopleDetailsScreen/{$NAME_KEY}",
    ) {
        fun destination(name: String): String {
            return "$peopleDetailsScreen/$name"
        }
    }


    companion object {
        const val NAME_KEY = "name"


        const val mainScreenRoute = "mainScreen"
        const val peopleDetailsScreen = "peopleDetailsScreen"
    }
}