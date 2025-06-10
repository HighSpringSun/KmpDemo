package com.kmpstudy.samples.modifier_system.modifier_basics

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// 使用 @Composable 注解表示这是一个可组合函数，用于构建 Jetpack Compose 的 UI 界面
@Composable
fun ModifierBasicExample() {
    // Text 是一个基础的 UI 组件，用于显示文本内容
    Text(
        text = "Hello Compose", // 要显示的文本内容

        // modifier 参数用于对组件进行外观和行为上的修饰（如样式、布局、交互等）
        modifier = Modifier
            // 设置内边距为 16.dp（dp 是 Jetpack Compose 中的单位，代表密度无关像素）
            .padding(16.dp)

            // 设置背景颜色为浅灰色（Color.LightGray 是 Compose 提供的一个预定义颜色）
            .background(Color.LightGray)

            // 添加点击事件支持，当用户点击该文本时会执行大括号中的代码
            // 这里目前为空，你可以在这里添加具体的响应逻辑，比如跳转页面、弹出 Toast 等
            .clickable {

            }
    )
}

@Composable
fun ModifierOrderMattersExample() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "顺序一: background -> clip", style = MaterialTheme.typography.titleSmall)
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Red)
                .clip(CircleShape)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Centered", color = Color.White)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "顺序二: clip -> background", style = MaterialTheme.typography.titleSmall)
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(Color.Red)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Centered", color = Color.White)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "顺序三: padding -> background -> clip", style = MaterialTheme.typography.titleSmall)
        Box(
            modifier = Modifier
                .size(120.dp)
                .padding(16.dp)
                .background(Color.Red)
                .clip(CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text("Centered", color = Color.White)
        }
    }
}