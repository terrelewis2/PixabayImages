package com.terrellewis.pixabay.images.feature_images.data.repository

import com.terrellewis.pixabay.images.core.util.NetworkConnection
import com.terrellewis.pixabay.images.core.util.Resource
import com.terrellewis.pixabay.images.feature_images.data.local.dao.ImageDao
import com.terrellewis.pixabay.images.feature_images.data.local.mapper.toImage
import com.terrellewis.pixabay.images.feature_images.data.local.mapper.toLocalImage
import com.terrellewis.pixabay.images.feature_images.data.remote.api.ImagesApi
import com.terrellewis.pixabay.images.feature_images.data.remote.mapper.toImages
import com.terrellewis.pixabay.images.feature_images.domain.model.Image
import com.terrellewis.pixabay.images.feature_images.domain.repository.ImageRepository
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val imageDao: ImageDao,
    private val imagesApi: ImagesApi
): ImageRepository {
    override suspend fun getImages(query: String): Resource<List<Image>> {
        return try {
            if(NetworkConnection.isConnected()) {
                val images = imagesApi.getImages(query).toImages()
                val localImages = images.map {
                    it.toLocalImage()
                }
                imageDao.insertImages(localImages)
                Timber.d("Images fetched from API successfully: $images")
                Resource.Success(images)
            } else {
                val images = imageDao.getImages()
                    .map {
                        it.toImage()
                    }.filter {
                        it.tags.contains(query)
                    }
                if(images.isEmpty()) {
                    Timber.d("No images found in db for query")
                    Resource.Error("No internet connection")
                } else {
                    Timber.d("Images found in db for query")
                    Resource.Success(images)
                }
            }
        } catch (e: HttpException) {
            Timber.d("Error fetching images : ${e.localizedMessage}")
            Resource.Error(e.localizedMessage ?: "Error occurred")
        } catch (e: IOException) {
            Timber.d("Error fetching images : ${e.localizedMessage}")
            Resource.Error("Issue fetching images, try again later")
        }
    }

    override suspend fun getImageById(id: Int): Image {
        return imageDao.getImageById(id).toImage()
    }
}