package com.example.lokalandroidassignment.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lokalandroidassignment.ui.screen.BottomBarScreen

@Composable
fun MainNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.BottomBar.route
    ) {
        composable(Routes.BottomBar.route) {
            BottomBarScreen()
        }

    }
}