package com.terrellewis.pixabay.images.feature_images.presentation.images_list.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.terrellewis.pixabay.images.core.presentation.components.AppCard
import com.terrellewis.pixabay.images.core.presentation.components.AppImage
import com.terrellewis.pixabay.images.core.presentation.components.AppTag
import com.terrellewis.pixabay.images.core.presentation.components.AppText
import com.terrellewis.pixabay.images.core.util.defaultPadding
import com.terrellewis.pixabay.images.core.util.defaultSpacerHeight
import com.terrellewis.pixabay.images.core.util.horizontalPadding
import com.terrellewis.pixabay.images.core.util.roundedCornerShape
import com.terrellewis.pixabay.images.feature_images.domain.model.Image

@Composable
fun ImageListItem(
    image: Image,
    onItemClick: (Image) -> Unit
) {

    AppCard(
        modifier = Modifier
            .defaultPadding()
            .width(200.dp)
            .height(270.dp)
            .clickable {
                onItemClick(image)
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                contentAlignment = Alignment.Center
            ) {
                AppImage(
                    imageUrl = image.largeImageUrl,
                    contentDescription = null,
                    modifier = Modifier.roundedCornerShape(
                        topStart = 5.dp,
                        topEnd = 5.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
            }

            Column(
                modifier = Modifier.horizontalPadding()
            ) {

                Spacer(modifier = Modifier.defaultSpacerHeight())

                AppText(
                    text = image.username,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.defaultSpacerHeight())

                FlowRow(
                    mainAxisSpacing = 10.dp,
                    crossAxisSpacing = 10.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    image.tags.forEach { tag ->
                        AppTag(tag = tag)
                    }
                }
            }
        }
    }

}