package com.terrellewis.pixabay.images.feature_images.presentation.images_list.state

import com.terrellewis.pixabay.images.feature_images.domain.model.Image

data class ImagesListState(
    val isLoading: Boolean = false,
    val images: List<Image> = emptyList(),
    val error: String? = null
)