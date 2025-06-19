package com.kmpstudy.samples.layout_system.row_and_column

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kmpdemo.composeapp.generated.resources.Res
import kmpdemo.composeapp.generated.resources.tie_dog
import org.jetbrains.compose.resources.painterResource

@Composable
fun RowExamples() {
    Column(modifier = Modifier.padding(16.dp)) {
        // 基础行布局
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Gray),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("左")
            Text("中")
            Text("右")
        }

        Spacer(modifier = Modifier.height(32.dp))

        // 居中对齐
        Row(
            modifier = Modifier.fillMaxWidth()
                .border(1.dp, Color.Gray),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.Star, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("带图标的文本")
        }
    }
}


@Composable
fun ColumnExamples() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("标题", style = MaterialTheme.typography.headlineMedium)
        Text("副标题", style = MaterialTheme.typography.bodyLarge)
        Button(onClick = { /* 处理点击 */ }) {
            Text("按钮")
        }
    }
}

@Composable
fun ListItemExample() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(Res.drawable.tie_dog),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text("用户名", style = MaterialTheme.typography.titleMedium)
                Text("描述信息", style = MaterialTheme.typography.bodyMedium)
            }
        }
        IconButton(onClick = { /* 处理点击 */ }) {
            Icon(Icons.Default.MoreVert, contentDescription = "更多")
        }
    }
}