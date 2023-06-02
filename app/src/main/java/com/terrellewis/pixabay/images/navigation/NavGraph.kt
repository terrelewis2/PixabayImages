package com.terrellewis.pixabay.images.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.terrellewis.pixabay.images.feature_images.presentation.image_detail.ImageDetailScreen
import com.terrellewis.pixabay.images.feature_images.presentation.images_list.ImagesListScreen

@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screen.ImagesListScreen.route) {
        composable(route = Screen.ImagesListScreen.route) {
            ImagesListScreen(navController = navController)
        }

        composable(
            route = Screen.ImageDetailScreen.routeWithArgument,
            arguments = listOf(
                navArgument(Screen.ImageDetailScreen.arg) {
                    type = NavType.IntType
                }
            )
        ) {
            ImageDetailScreen()
        }
    }
}