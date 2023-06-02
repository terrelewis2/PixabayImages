package com.terrellewis.pixabay.images.feature_images.data.remote.dto

import com.squareup.moshi.Json

data class ImageDTO(
    val id: Int,
    @field:Json(name = "previewURL")
    val previewUrl: String?,
    @field:Json(name = "largeImageURL")
    val largeImageUrl: String?,
    @field:Json(name = "webformatURL")
    val webFormatUrl: String?,
    val tags: String?,
    @field:Json(name = "user")
    val username: String?,
    @field:Json(name = "likes")
    val likesCount: Int?,
    @field:Json(name = "downloads")
    val downloadsCount: Int?,
    @field:Json(name = "comments")
    val commentsCount: Int?,
)
