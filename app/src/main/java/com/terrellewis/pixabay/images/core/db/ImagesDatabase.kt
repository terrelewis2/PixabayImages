package com.terrellewis.pixabay.images.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.terrellewis.pixabay.images.core.db.ImagesDatabase.Companion.DATABASE_VERSION
import com.terrellewis.pixabay.images.feature_images.data.local.dao.ImageDao
import com.terrellewis.pixabay.images.feature_images.data.local.dto.LocalImageDTO

@Database(
    entities = [LocalImageDTO::class],
    version = DATABASE_VERSION,
    exportSchema = true
)
abstract class ImagesDatabase : RoomDatabase() {
    abstract fun imageDao(): ImageDao

    companion object {
        const val DATABASE_NAME = "images_db"
        const val DATABASE_VERSION = 1
    }
}