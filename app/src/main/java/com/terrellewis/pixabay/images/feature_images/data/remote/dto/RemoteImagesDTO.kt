package com.terrellewis.pixabay.images.feature_images.data.remote.dto

import com.squareup.moshi.Json

data class RemoteImagesDTO(
    @field:Json(name = "hits")
    val photos: List<RemoteImageDTO>,
    val total: Int,
    val totalHits: Int
)
