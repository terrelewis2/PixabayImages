package com.terrellewis.pixabay.images.feature_images.data.remote.dto

import com.squareup.moshi.Json

data class ImagesDTO(
    @field:Json(name = "hits")
    val photos: List<ImageDTO>,
    val total: Int,
    val totalHits: Int
)
