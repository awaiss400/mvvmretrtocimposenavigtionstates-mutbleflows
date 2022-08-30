package com.stone.retromvvmgenerics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stone.retromvvmgenerics.APi.Posts

@Composable
fun MonthDialog(onClose: () -> Unit,posts: Posts) {
    AlertDialog(
        onDismissRequest = onClose,
        title = {
            Text(text = "${posts.id}")
        },
        text = {
            Text(
                "${posts.body}"
            )
        },
        buttons = {
            Row(
                modifier = Modifier.padding(all = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onClose
                ) {
                    Text("Dismiss")
                }
            }
        }
    )
}