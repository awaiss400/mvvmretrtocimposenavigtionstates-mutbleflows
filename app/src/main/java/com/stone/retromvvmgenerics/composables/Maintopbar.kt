package com.stone.retromvvmgenerics.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


@Composable
fun MainTopBar(
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        elevation = 4.dp,
        title = {
            Text(text = "stringResource(id = R.string.app_name)")
        },
        actions = actions
    )
}

@Composable
fun LoadingIndicator() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center

    ) {
        CircularProgressIndicator()
    }
}
@Composable
fun LoadingUi() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center

        ) {
            CircularProgressIndicator()
        }
    }
