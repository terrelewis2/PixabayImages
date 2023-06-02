package com.terrellewis.pixabay.images.core.presentation.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import coil.transform.Transformation


@Composable
fun AppImage(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    transformation: Transformation? = null,
) {
    val imageRequest = if (transformation != null) {
        ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .scale(Scale.FILL)
            .crossfade(true)
            .crossfade(500)
            .error(android.R.drawable.ic_dialog_alert)
            .transformations(transformation)
            .build()
    } else {
        ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .scale(Scale.FILL)
            .error(android.R.drawable.ic_dialog_alert)
            .crossfade(true)
            .crossfade(500)
            .build()
    }
    SubcomposeAsyncImage(
        model = imageRequest,
        contentDescription = contentDescription,
        modifier = modifier,
        loading = {
            CircularProgressIndicator()
        },
        contentScale = contentScale
    )
}