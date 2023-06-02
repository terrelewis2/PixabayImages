package com.terrellewis.pixabay.images.feature_images.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.terrellewis.pixabay.images.feature_images.data.local.entities.ImageEntity

@Dao
interface ImageDao {
    @Upsert
    suspend fun insertImages(images: List<ImageEntity>)

    @Query("SELECT * FROM images WHERE id = :id")
    suspend fun getImageById(id: Int): ImageEntity

    @Query("SELECT * FROM images")
    suspend fun getImages(): List<ImageEntity>
}