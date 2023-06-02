package com.terrellewis.pixabay.images.feature_images.presentation.image_detail.state

import com.terrellewis.pixabay.images.feature_images.domain.model.Image

data class ImageDetailState(
    val isLoading: Boolean = false,
    val image: Image? = null
)
