package com.terrellewis.pixabay.images.feature_images.data.remote.mapper

import com.terrellewis.pixabay.images.core.util.getAsList
import com.terrellewis.pixabay.images.feature_images.data.remote.dto.RemoteImageDTO
import com.terrellewis.pixabay.images.feature_images.data.remote.dto.RemoteImagesDTO
import com.terrellewis.pixabay.images.feature_images.domain.model.Image

fun RemoteImageDTO.toImage(): Image {
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
    )
}

fun RemoteImagesDTO.toImages(): List<Image> {
    return photos.map { it.toImage() }
}

fun Image.toRemoteImage(): RemoteImageDTO {
    return RemoteImageDTO(
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