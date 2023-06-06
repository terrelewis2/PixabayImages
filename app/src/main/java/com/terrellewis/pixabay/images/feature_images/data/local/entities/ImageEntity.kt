package com.terrellewis.pixabay.images.feature_images.data.local.entities

import androidx.room.Entity

@Entity(tableName = "images", primaryKeys = [("id")])
data class ImageEntity(
    val id: Int,
    val previewUrl: String,
    val largeImageUrl: String,
    val webFormatUrl: String,
    val tags: String,
    val username: String,
    val likesCount: Int,
    val downloadsCount: Int,
    val commentsCount: Int,
    val query: String,
)