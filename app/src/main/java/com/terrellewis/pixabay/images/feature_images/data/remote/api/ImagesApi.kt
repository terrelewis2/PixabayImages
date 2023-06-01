package com.terrellewis.pixabay.images.feature_images.data.remote.api

import com.terrellewis.pixabay.images.BuildConfig
import com.terrellewis.pixabay.images.feature_images.data.remote.dto.RemoteImagesDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ImagesApi {
    @GET("/api/")
    suspend fun getImages(
        @Query("q") query: String,
        @Query("key") key: String = BuildConfig.PIXABAY_API_KEY
    ): RemoteImagesDTO
}