package com.terrellewis.pixabay.images.feature_images.presentation.images_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.terrellewis.pixabay.images.core.presentation.components.AppCard
import com.terrellewis.pixabay.images.core.presentation.components.AppText
import com.terrellewis.pixabay.images.core.util.defaultPadding
import com.terrellewis.pixabay.images.core.util.defaultScreenPadding
import com.terrellewis.pixabay.images.core.util.defaultSpacerWidth


@Composable
fun ImagesSearchBar(
    defaultText: String? = null,
    hint: String = "Search for images like \"fruits\"",
    onSearch: (String) -> Unit
) {

    val defaultSearchTerm = defaultText ?: ""
    val text = remember {
        mutableStateOf(defaultSearchTerm)
    }

    var isHintDisplayed by remember {
        mutableStateOf(text.value == "" && hint != "")
    }

    AppCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .defaultScreenPadding()
    ) {
        Row(
            modifier = Modifier
                .defaultPadding()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_search),
                contentDescription = "Search by keywords",
                modifier = Modifier.padding(
                    start = 5.dp
                )
            )

            Spacer(modifier = Modifier.defaultSpacerWidth())

            Box(modifier = Modifier.fillMaxWidth()) {
                BasicTextField(
                    value = text.value,
                    textStyle = TextStyle(
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                    onValueChange = {
                        text.value = it
                        isHintDisplayed = it.trim().isEmpty()
                        onSearch(it)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                )
                if (isHintDisplayed) {
                    AppText(
                        text = hint,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}