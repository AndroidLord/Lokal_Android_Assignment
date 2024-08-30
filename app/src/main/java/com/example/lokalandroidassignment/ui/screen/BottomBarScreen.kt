package com.example.lokalandroidassignment.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lokalandroidassignment.ui.navigation.BottomNavGraph
import com.example.lokalandroidassignment.ui.navigation.BottomNavRoutes
import com.example.lokalandroidassignment.ui.theme.LightBlue

@Composable
fun BottomBarScreen(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current.applicationContext
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()

    Scaffold{innerPadding ->


        Box(
            modifier = modifier.background(LightBlue)
        ) {

            BottomNavGraph(innerPadding = innerPadding,navController = navController)

            val currentRoute = backStackEntry?.destination?.route
            when (currentRoute) {
                BottomNavRoutes.JobDetail.route,
                BottomNavRoutes.BookmarkDetail.route
                -> return@Box
            }
            MyBottomAppBar(
                modifier = Modifier.align(Alignment.BottomCenter),
                navController = navController
            )
        }

    }
}

@Composable
fun MyBottomAppBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    var selectedItem by rememberSaveable { mutableIntStateOf(0) }

    LaunchedEffect(key1 = currentBackStackEntry) {

        selectedItem = when (currentBackStackEntry?.destination?.route) {
            BottomNavRoutes.Bookmark.route -> 1
            else -> 0
        }

    }

    val list = listOf(
        NavigationItem(
            icon = Icons.Filled.Work,
            route = BottomNavRoutes.Job.route
        ),
        NavigationItem(
            icon = Icons.Default.Bookmark,
            route = BottomNavRoutes.Bookmark.route
        ),
    )

    BottomAppBar(
        modifier = modifier
            //.padding(vertical = 16.dp, horizontal = 8.dp)
            .clip(RoundedCornerShape(15.dp))
            .border(2.dp, MaterialTheme.colorScheme.onPrimaryContainer, RoundedCornerShape(15.dp))
            .fillMaxWidth()
        ,
        containerColor = MaterialTheme.colorScheme.onTertiary,
        contentColor = MaterialTheme.colorScheme.onTertiaryContainer
    ) {

        list.forEachIndexed { index, item ->

            NavigationBarItem(
                selected = (selectedItem == index),
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.tertiary,
                    unselectedTextColor = MaterialTheme.colorScheme.tertiary

                ),
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                label = {
                    Text(text = item.route)
                },
                icon = {
                    Icon( imageVector = item.icon, contentDescription = null )
                }
            )


        }

    }

}


data class NavigationItem(
    val icon: ImageVector,
    val route: String,
)