package com.terrellewis.pixabay.images.core.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.terrellewis.pixabay.images.R
import com.terrellewis.pixabay.images.core.util.defaultSpacerWidth

@Composable
fun IconText(
    text: String,
    modifier: Modifier,
    icon: Int,
    contentDescription: String,
    iconTint: Color = MaterialTheme.colorScheme.primary

) {

    Icon(
        painter = painterResource(id = icon),
        contentDescription = contentDescription,
        tint = iconTint
    )

    Spacer(modifier = Modifier.defaultSpacerWidth())

    AppText(
        modifier = modifier,
        text = text,
        color = Color.Gray
    )




}