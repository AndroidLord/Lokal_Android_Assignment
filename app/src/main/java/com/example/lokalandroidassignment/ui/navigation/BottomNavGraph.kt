package com.example.lokalandroidassignment.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.lokalandroidassignment.ui.screen.Job.ErrorScreen
import com.example.lokalandroidassignment.ui.screen.Job.JobScreen
import com.example.lokalandroidassignment.ui.screen.Job.JobDetailScreen
import com.example.lokalandroidassignment.ui.screen.MainViewModel
import com.example.lokalandroidassignment.ui.screen.bookmark.BookmarkDetailScreen
import com.example.lokalandroidassignment.ui.screen.bookmark.BookmarkScreen

@Composable
fun BottomNavGraph(
    innerPadding: PaddingValues,
    navController: NavHostController
) {

    val viewModel: MainViewModel = hiltViewModel()

    NavHost(
        modifier = Modifier.padding(innerPadding),
        navController = navController,
        startDestination = BottomNavRoutes.Job.route
    ) {

        composable(BottomNavRoutes.Job.route) {
            JobScreen(viewModal = viewModel, navController = navController)
        }

        composable(BottomNavRoutes.Bookmark.route) {
            BookmarkScreen(viewModel = viewModel, navController = navController)
        }

        composable(
            route = BottomNavRoutes.JobDetail.route,
            arguments = listOf(
                navArgument("jobId") {
                    type = NavType.LongType
                }
            )
        ) {
            val jobId = it.arguments?.getLong("jobId")
            val job = viewModel.getJobById(jobId!!)
            job?.let {
                JobDetailScreen(job = it)
            } ?: ErrorScreen(message = "Job Id $jobId not found")

        }

        composable(
            route = BottomNavRoutes.BookmarkDetail.route,
            arguments = listOf(navArgument("jobId") { type = NavType.LongType })
        ) { navBackStackEntry ->

            val jobId = navBackStackEntry.arguments?.getLong("jobId")
            val job = viewModel.getBookmarkJobById(jobId!!)
            job?.let {
                BookmarkDetailScreen(job = it)
            } ?: ErrorScreen(message = "Bookmarked Job $jobId not found")

        }

    }
}