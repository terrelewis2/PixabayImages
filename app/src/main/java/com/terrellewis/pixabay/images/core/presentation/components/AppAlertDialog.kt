package com.terrellewis.pixabay.images.core.presentation.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AppAlertDialog(
    onDismissRequest: () -> Unit,
    title: String,
    text: String,
    confirmText: String,
    dismissText: String,
    onConfirmClicked: () -> Unit,
    onDismissClicked: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            Text(text = title)
        },
        text = {
            Text(text)
        },
        confirmButton = {
            Button(
                onClick = onConfirmClicked
            ) {
                Text(confirmText)
            }
        },
        dismissButton = {
            Button(
                onClick = onDismissClicked
            ) {
                Text(dismissText)
            }
        })
}