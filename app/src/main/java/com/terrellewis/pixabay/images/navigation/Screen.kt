package com.terrellewis.pixabay.images.navigation

sealed class Screen(val route: String) {
    object ImagesListScreen : Screen("ImagesListScreen")
}