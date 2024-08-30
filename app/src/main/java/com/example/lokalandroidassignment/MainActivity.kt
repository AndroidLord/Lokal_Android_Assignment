package com.example.lokalandroidassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.lokalandroidassignment.data.remote.JobApi
import com.example.lokalandroidassignment.ui.navigation.MainNavGraph
import com.example.lokalandroidassignment.ui.theme.LokalAndroidAssignmentTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

   // @Inject lateinit var jobApi: JobApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LokalAndroidAssignmentTheme {

                MainNavGraph(navController = rememberNavController())

            }
        }


    }
}

