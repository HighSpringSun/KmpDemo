package com.kmpstudy.samples.basic_components.divider_and_spacer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DividerExamples() {
    Column(modifier = Modifier.padding(16.dp)) {
        // 基础分隔线
        Text("第一项")
        Divider()
        Text("第二项")

        Spacer(modifier = Modifier.height(16.dp))

        // 自定义分隔线
        Text("自定义分隔线")
        Divider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.primary
        )
        Text("下一项")

        // 带缩进的分隔线
        Divider(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .padding(start = 32.dp)
        )
    }
}

@Composable
fun SpacerExamples() {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        // 垂直间距
        Text("第一行文本")
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
                .background(Color.Red.copy(0.5f))
        )
        Text("第二行文本")

        // 水平间距示例
        Row(modifier = Modifier.fillMaxWidth()) {
            Text("左侧")
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .weight(1f).background(Color.Red.copy(0.5f))
            ) // 弹性间距
            Text("右侧")
        }

        // 固定宽度间距
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.Home, contentDescription = null)
            Spacer(modifier = Modifier.height(8.dp).width(8.dp).background(Color.Red.copy(0.5f)))
            Text("首页")
        }
    }
}

@Composable
fun CommonLayoutPatterns() {
    Column(modifier = Modifier.padding(16.dp)) {
        // 列表项间距
        ListItem(
            headlineContent = { Text("列表项 1") }
        )
        Divider()
        Spacer(modifier = Modifier.height(8.dp))
        ListItem(
            headlineContent = { Text("列表项 2") }
        )

        // 卡片内容间距
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("标题", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text("描述内容")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { /* 处理点击 */ }) {
                    Text("按钮")
                }
            }
        }
    }
}