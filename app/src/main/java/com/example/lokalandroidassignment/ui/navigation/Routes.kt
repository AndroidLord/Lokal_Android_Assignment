package com.example.lokalandroidassignment.ui.navigation

sealed class Routes(val route: String) {
    object BottomBar : Routes("bottomBar")
}