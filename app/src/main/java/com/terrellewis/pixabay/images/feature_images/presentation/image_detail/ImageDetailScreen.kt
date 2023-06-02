package com.terrellewis.pixabay.images.feature_images.presentation.image_detail

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.terrellewis.pixabay.images.feature_images.presentation.image_detail.components.ImageDetail
import com.terrellewis.pixabay.images.feature_images.presentation.image_detail.viewmodel.ImageDetailViewModel

@Composable
fun ImageDetailScreen(
    viewModel: ImageDetailViewModel = hiltViewModel()
) {
    val state = viewModel.imageState.value
    state.image?.let { image ->
        ImageDetail(image = image)
    }
}