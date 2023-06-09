package com.terrellewis.pixabay.images.feature_images.data.remote.mapper

import com.terrellewis.pixabay.images.core.util.getAsList
import com.terrellewis.pixabay.images.feature_images.data.remote.dto.ImageDTO
import com.terrellewis.pixabay.images.feature_images.data.remote.dto.ImagesDTO
import com.terrellewis.pixabay.images.feature_images.domain.model.Image

fun ImageDTO.toImage(query: String): Image {
    return Image(
        id = id,
        previewUrl = previewUrl ?: "",
        largeImageUrl = largeImageUrl ?: "",
        webFormatUrl = webFormatUrl ?: "",
        tags = tags?.getAsList() ?: emptyList(),
        username = username ?: "",
        likesCount = likesCount ?: 0,
        downloadsCount = downloadsCount ?: 0,
        commentsCount = commentsCount ?: 0,
        query = query
    )
}

fun ImagesDTO.toImages(query: String): List<Image> {
    return photos.map { it.toImage(query) }
}

fun Image.toImageDTO(): ImageDTO {
    return ImageDTO(
        id = id,
        previewUrl = previewUrl,
        largeImageUrl = largeImageUrl,
        webFormatUrl = webFormatUrl,
        tags = tags.joinToString(separator = ","),
        username = username,
        likesCount = likesCount,
        downloadsCount = downloadsCount,
        commentsCount = commentsCount,
    )

}