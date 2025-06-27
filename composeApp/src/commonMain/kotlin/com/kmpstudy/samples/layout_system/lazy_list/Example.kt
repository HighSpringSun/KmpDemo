package com.kmpstudy.samples.layout_system.lazy_list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kmpdemo.composeapp.generated.resources.Res
import kmpdemo.composeapp.generated.resources.cat
import kmpdemo.composeapp.generated.resources.panda
import kmpdemo.composeapp.generated.resources.tie_dog
import org.jetbrains.compose.resources.painterResource


@Composable
fun SimpleListExample() {
    LazyColumn {
        items(50) { index ->
            Text(
                text = "Item #$index",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}

@Composable
fun HorizontalListExample() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(10) { index ->
            Card(
                modifier = Modifier
                    .size(150.dp)
                    .padding(4.dp)
            ) {
                Text("Card #$index")
            }
        }
    }
}

@Composable
fun ImageCarousel() {
    val images = listOf(
        Res.drawable.tie_dog,
        Res.drawable.panda,
        Res.drawable.cat
    )
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        items(images) { image ->
            Image(
                painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .fillParentMaxWidth() // 填充父容器宽度
                    .aspectRatio(16f / 9f)  // 固定宽高比
            )
        }
    }
}


@Composable
fun FixedGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 固定2列
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(10) { index ->
            GridItem(index)
        }
    }
}

@Composable
fun GridItem(index: Int) {
    Card(
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Text(
            index.toString(),
            modifier = Modifier
                .height(40.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun AdaptiveGrid() {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp), // 最小列宽
        contentPadding = PaddingValues(8.dp)
    ) {
        items(20) { index ->
            GridItem(index)
        }
    }
}


@Composable
fun CustomListItem() {
    LazyColumn {
        items(10) { index ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { /* 处理点击 */ },
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(Res.drawable.tie_dog),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(
                            text = "标题 #$index",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "描述内容",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}

