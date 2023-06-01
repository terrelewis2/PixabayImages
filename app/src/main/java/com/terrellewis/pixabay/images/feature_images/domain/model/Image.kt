package com.terrellewis.pixabay.images.feature_images.domain.model

data class Image(
    val id: Int,
    val previewUrl: String,
    val largeImageUrl: String,
    val webFormatUrl: String,
    val tags: List<String>,
    val username: String,
    val likesCount: Int,
    val downloadsCount: Int,
    val commentsCount: Int,
)
