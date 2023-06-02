package com.terrellewis.pixabay.images.navigation

sealed class Screen(val route: String) {
    object ImagesListScreen : Screen("ImagesListScreen")
    object ImageDetailScreen : Screen("ImageDetailScreen") {
        const val routeWithArgument = "ImageDetailScreen/{id}"
        const val arg = "id"
    }
}