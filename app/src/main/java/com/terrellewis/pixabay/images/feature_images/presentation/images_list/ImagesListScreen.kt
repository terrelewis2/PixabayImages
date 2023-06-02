package com.terrellewis.pixabay.images.feature_images.presentation.images_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.terrellewis.pixabay.images.core.presentation.components.AppText
import com.terrellewis.pixabay.images.core.util.defaultPadding
import com.terrellewis.pixabay.images.core.util.defaultSpacerHeight
import com.terrellewis.pixabay.images.feature_images.domain.model.Image
import com.terrellewis.pixabay.images.feature_images.presentation.images_list.components.ImageListItem
import com.terrellewis.pixabay.images.feature_images.presentation.images_list.components.ImagesSearchBar
import com.terrellewis.pixabay.images.feature_images.presentation.images_list.viewmodel.ImagesListViewModel

@Composable
fun ImagesListScreen(
    navController: NavController,
    imagesListViewModel: ImagesListViewModel = hiltViewModel()
) {
    val state = imagesListViewModel.imagesList.value
    val query = imagesListViewModel.searchQuery.value
    val dialogState = remember {
        mutableStateOf(false)
    }

    val selectedItem = remember {
        mutableStateOf<Image?>(null)
    }

    if (dialogState.value) {
        TODO("Show Dialog confirming if user wants to see details of the image")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        ImagesSearchBar(
            defaultText = query,
            onSearch = {
                imagesListViewModel.getImages(
                    query = it
                )
            }
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 16.dp,
                    vertical = 2.dp
                )
        ) {

            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            if (state.error != null) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .defaultPadding()
                ) {
                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_dialog_alert),
                        contentDescription = "No Internet"
                    )

                    Spacer(modifier = Modifier.defaultSpacerHeight())

                    AppText(
                        text = state.error,
                        color = Color.Gray
                    )
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                items(state.images.size) { index ->
                    ImageListItem(
                        image = state.images[index],
                        onItemClick = { item ->
                            dialogState.value = true
                            selectedItem.value = item
                        }
                    )
                }
            }
        }
    }
}