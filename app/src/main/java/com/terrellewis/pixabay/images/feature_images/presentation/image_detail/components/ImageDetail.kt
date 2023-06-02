package com.terrellewis.pixabay.images.feature_images.presentation.image_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.terrellewis.pixabay.images.core.presentation.components.AppImage
import com.terrellewis.pixabay.images.core.presentation.components.AppTag
import com.terrellewis.pixabay.images.core.presentation.components.AppText
import com.terrellewis.pixabay.images.core.util.defaultPadding
import com.terrellewis.pixabay.images.core.util.defaultSpacerHeight
import com.terrellewis.pixabay.images.feature_images.domain.model.Image

@Composable
fun ImageDetail(
    image: Image
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(290.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                AppImage(
                    imageUrl = image.largeImageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            }
        }

        Spacer(modifier = Modifier.defaultSpacerHeight())

        Row(
            modifier = Modifier
                .defaultPadding()
                .wrapContentHeight()
        ) {

            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier
                        .defaultPadding()
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AppText(
                                text = "Uploaded by: ",
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Normal,
                                color = MaterialTheme.colorScheme.primary
                            )
                            AppText(
                                text = image.username,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )

                        }

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

                Spacer(modifier = Modifier.defaultSpacerHeight())

                Divider()

                Spacer(modifier = Modifier.defaultSpacerHeight())

                ImageStats(
                    image.likesCount,
                    image.commentsCount,
                    image.downloadsCount
                )
            }
        }
    }
}