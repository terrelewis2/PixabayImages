package com.terrellewis.pixabay.images.feature_images.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.terrellewis.pixabay.images.feature_images.data.local.dto.LocalImageDTO

@Dao
interface ImageDao {
    @Upsert
    suspend fun insertImages(galleryImageEntities: List<LocalImageDTO>)

    @Query("SELECT * FROM images WHERE id = :id")
    suspend fun getImageById(id: Int): LocalImageDTO

    @Query("SELECT * FROM images")
    suspend fun getImages(): List<LocalImageDTO>
}