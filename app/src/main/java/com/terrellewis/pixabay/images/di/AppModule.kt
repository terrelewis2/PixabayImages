package com.terrellewis.pixabay.images.di

import android.content.Context
import androidx.room.Room
import com.terrellewis.pixabay.images.core.db.ImagesDatabase
import com.terrellewis.pixabay.images.core.util.Constants.BASE_URL
import com.terrellewis.pixabay.images.feature_images.data.local.dao.ImageDao
import com.terrellewis.pixabay.images.feature_images.data.remote.api.ImagesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideGalleryDatabase(
        @ApplicationContext applicationContext: Context,
    ) = Room.databaseBuilder(
        applicationContext,
        ImagesDatabase::class.java,
        ImagesDatabase.DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideImagesApi() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(ImagesApi::class.java)

    @Provides
    @Singleton
    fun provideImageDao(database: ImagesDatabase): ImageDao {
        return database.imageDao()
    }
}