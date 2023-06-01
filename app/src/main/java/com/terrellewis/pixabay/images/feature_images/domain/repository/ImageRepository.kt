package com.terrellewis.pixabay.images.feature_images.domain.repository

import com.terrellewis.pixabay.images.core.util.Resource
import com.terrellewis.pixabay.images.feature_images.domain.model.Image

interface ImageRepository {

    suspend fun getImages(query: String): Resource<List<Image>>

    suspend fun getImageById(id: Int): Image
}