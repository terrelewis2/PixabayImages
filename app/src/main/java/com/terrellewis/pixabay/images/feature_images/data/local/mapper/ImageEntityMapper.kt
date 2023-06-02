package com.terrellewis.pixabay.images.feature_images.data.local.mapper

import com.terrellewis.pixabay.images.core.util.getAsList
import com.terrellewis.pixabay.images.feature_images.data.local.entities.ImageEntity
import com.terrellewis.pixabay.images.feature_images.domain.model.Image


fun ImageEntity.toImage(): Image {
    return Image(
        id = id,
        previewUrl = previewUrl,
        largeImageUrl = largeImageUrl,
        webFormatUrl = webFormatUrl,
        tags = tags.getAsList(),
        username = username,
        likesCount = likesCount,
        downloadsCount = downloadsCount,
        commentsCount = commentsCount,
    )
}

fun Image.toImageEntity(): ImageEntity {
    return ImageEntity(
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