package com.terrellewis.pixabay.images.feature_images.domain.use_case

import com.terrellewis.pixabay.images.feature_images.domain.repository.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    operator fun invoke(query: String) = flow {
        val images = repository.getImages(query)
        emit(images)
    }.flowOn(Dispatchers.IO)
}