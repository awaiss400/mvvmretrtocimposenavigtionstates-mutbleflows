package com.stone.retromvvmgenerics.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.stone.retromvvmgenerics.APi.Posts
import com.stone.retromvvmgenerics.Recycler

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WordListUi(posts: List<Posts>) {
Scaffold(Modifier.fillMaxSize()) {
    Recycler(posts = posts)
}
}
