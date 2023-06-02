package com.terrellewis.pixabay.images.feature_images.presentation.image_detail.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.terrellewis.pixabay.images.R
import com.terrellewis.pixabay.images.core.presentation.components.IconText
import com.terrellewis.pixabay.images.core.util.defaultPadding
import com.terrellewis.pixabay.images.core.util.defaultSpacerWidth

@Composable
fun ImageStats(
    likesCount: Int,
    commentsCount: Int,
    downloadsCount: Int,
){
    Row(
        modifier = Modifier
            .defaultPadding(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconText(
            text = likesCount.toString(),
            modifier = Modifier.weight(1f),
            icon = R.drawable.ic_like,
            contentDescription = "Likes"
        )

        Spacer(modifier = Modifier.defaultSpacerWidth())

        IconText(
            text = commentsCount.toString(),
            modifier = Modifier.weight(1f),
            icon = R.drawable.ic_comment,
            contentDescription = "Comments"
        )


        Spacer(modifier = Modifier.defaultSpacerWidth())

        IconText(
            text = downloadsCount.toString(),
            modifier = Modifier.weight(1f),
            icon = R.drawable.ic_download,
            contentDescription = "Downloads"
        )
    }
}