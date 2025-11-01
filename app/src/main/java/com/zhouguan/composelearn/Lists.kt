package com.zhouguan.composelearn

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import kotlinx.coroutines.launch

@Composable
fun SimpleColumn() {
    Column {
        repeat(100) {
            Text("Item # $it", style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun SimpleList() {
    val scrollState = rememberScrollState()
    Column(Modifier.verticalScroll(scrollState)) {
        repeat(100) {
            Text(text = "Item #$it", style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun LazyList() {
    val scrollState = rememberLazyListState()
    LazyColumn(state = scrollState) {
        items(100) {
            Text(text = "Item #$it", style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Preview
@Composable
fun ScrollingList() {
    val listSize = 100
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(16.dp)
    ) {
        Row {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollToItem(0)
                    }
                }
            ) {
                Text(text = "Scroll to the top")
            }

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollToItem(listSize - 1)
                    }
                }
            ) {
                Text(text = "Scroll to the end")
            }
        }
        LazyColumn(state = scrollState) {
            items(listSize) {
                ImageListItem(index = it)
            }
        }
    }
}

@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberAsyncImagePainter(
                model = "https://64.media.tumblr.com/0c7cd1aec29ecba914894a9062522aa2/78ffdc42e9981308-65/s1280x1920/042fac79ef2fcb2df9300c3256661a62246b735c.jpg",
                onError = { error ->
                    Log.e("ImageLoadError", "Failed to load image: $error")
                }
            ),
            contentDescription = "Image",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "Item #$index", style = MaterialTheme.typography.titleSmall)
    }
}

