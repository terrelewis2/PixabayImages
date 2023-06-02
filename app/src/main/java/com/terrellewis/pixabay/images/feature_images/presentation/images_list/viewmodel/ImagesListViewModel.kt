package com.terrellewis.pixabay.images.feature_images.presentation.images_list.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.terrellewis.pixabay.images.core.util.Constants
import com.terrellewis.pixabay.images.core.util.Resource
import com.terrellewis.pixabay.images.feature_images.domain.use_case.GetImagesUseCase
import com.terrellewis.pixabay.images.feature_images.presentation.images_list.state.ImagesListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ImagesListViewModel @Inject constructor(
    private val getImagesUseCase: GetImagesUseCase,
) : ViewModel() {

    val searchQuery = mutableStateOf(Constants.DEFAULT_SEARCH_TERM)

    private val _imagesList = mutableStateOf(ImagesListState())
    val imagesList: State<ImagesListState> = _imagesList

    init {
        getImages(searchQuery.value)
    }

    fun getImages(query: String) {
        searchQuery.value = query
        getImagesUseCase(query).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _imagesList.value = ImagesListState(images = result.data ?: emptyList())
                }

                is Resource.Loading -> {
                    _imagesList.value = ImagesListState(isLoading = true)
                }

                is Resource.Error -> {
                    _imagesList.value = ImagesListState(error = result.message ?: "Unexpected Error")
                }
            }
        }.launchIn(viewModelScope)
    }
}