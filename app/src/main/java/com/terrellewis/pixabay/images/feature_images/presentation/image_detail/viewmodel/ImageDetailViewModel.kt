package com.terrellewis.pixabay.images.feature_images.presentation.image_detail.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.terrellewis.pixabay.images.feature_images.domain.use_case.GetImageByIdUseCase
import com.terrellewis.pixabay.images.feature_images.presentation.image_detail.state.ImageDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ImageDetailViewModel @Inject constructor(
    private val getImageByIdUseCase: GetImageByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _imageState = mutableStateOf(ImageDetailState())
    val imageState: State<ImageDetailState> = _imageState

    init {
        savedStateHandle.get<Int>("id")?.let { id ->
            getImageById(id)
        }
    }

    private fun getImageById(id: Int) {
        _imageState.value = ImageDetailState(isLoading = true)
        getImageByIdUseCase(id).onEach { image ->
            _imageState.value = ImageDetailState(image = image)
        }.launchIn(viewModelScope)
    }
}