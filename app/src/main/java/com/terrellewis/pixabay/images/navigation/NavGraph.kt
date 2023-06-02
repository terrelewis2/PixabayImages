package com.terrellewis.pixabay.images.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.terrellewis.pixabay.images.feature_images.presentation.images_list.ImagesListScreen

@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screen.ImagesListScreen.route) {
        composable(route = Screen.ImagesListScreen.route) {
            ImagesListScreen(navController = navController)
        }
    }
}