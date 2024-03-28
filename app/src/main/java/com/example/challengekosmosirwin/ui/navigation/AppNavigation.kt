package com.example.challengekosmosirwin.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.challengekosmosirwin.ui.screens.DetailScreen
import com.example.challengekosmosirwin.ui.screens.HomeScreen

@Composable
fun AppNavigationGraph(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN) {
        composable(Routes.HOME_SCREEN){
            HomeScreen(navController = navController)
        }

        composable("DETAIL/{status}"){ backStackEntry ->
            val status = backStackEntry.arguments?.getString("status")
            DetailScreen(status)
        }
    }

}