package com.stone.retromvvmgenerics


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stone.retromvvmgenerics.APi.Posts


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MovieItem(posts: Posts) {
    var showDialog by remember { mutableStateOf(false) }
    if (showDialog) {
        MonthDialog(onClose = { showDialog = false },posts)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .padding(8.dp, 4.dp),
onClick = {showDialog=true}

        ) {
        Surface(){
            Column {
                Text(text =posts.id.toString(), fontSize = 20.sp, color = Color.DarkGray )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = posts.title, fontSize = 15.sp, fontStyle = FontStyle.Italic)
            }
        }
    }
}

@Composable
fun Title(posts: Posts) {

}
@Composable
fun Recycler(posts:List<Posts>) {
    LazyColumn {
        itemsIndexed(items = posts){index, item ->
            MovieItem(item)
        }
    }

}

