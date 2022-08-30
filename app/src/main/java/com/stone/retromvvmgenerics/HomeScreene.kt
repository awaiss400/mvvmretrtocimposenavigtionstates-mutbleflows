package com.stone.retromvvmgenerics

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.stone.retromvvmgenerics.composables.LoadingUi
import com.stone.retromvvmgenerics.composables.WordListUi

@Composable
fun HomeScreen(viewModel:Myviewmodel) {
    val _words by viewModel.posts.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    val isError by viewModel.isError.collectAsState()

    when {
        isLoading -> {
            LoadingUi()

        }

        else -> {
            WordListUi(posts = _words)
        }

    }
}