package com.example.lokalandroidassignment.ui.screen.bookmark

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lokalandroidassignment.data.local.modal.BookmarkJob
import com.example.lokalandroidassignment.ui.navigation.BottomNavRoutes
import com.example.lokalandroidassignment.ui.screen.Job.ErrorScreen
import com.example.lokalandroidassignment.ui.screen.MainViewModel


@Composable
fun BookmarkScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: MainViewModel
) {

    val bookmarkJob by viewModel.bookmarkJob.collectAsState()

    Column {

        Text(text = "Bookmark", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(16.dp))

        when{
            bookmarkJob.isEmpty() -> NoBookmarkScreen()
            else -> BookmarkListScreen(modifier, bookmarkJob, navController, viewModel)
        }

    }



}

@Composable
fun NoBookmarkScreen(modifier: Modifier = Modifier) {
    ErrorScreen(message = "No bookmark found")
}

@Composable
private fun BookmarkListScreen(
    modifier: Modifier,
    bookmarkJob: List<BookmarkJob>,
    navController: NavController,
    viewModel: MainViewModel
) {
    Box(modifier = modifier) {


        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 70.dp)

        ) {
            items(bookmarkJob) { job ->

                BookmarkJobCard(
                    modifier = Modifier, job = job,
                    onInfoClicked = {
                        navController.navigate(BottomNavRoutes.BookmarkDetail.passBookmarkJobId(job.id))
                    },
                    removeBookmarkJob = { viewModel.removeBookmarkJob(it) }
                )

            }
        }
    }
}