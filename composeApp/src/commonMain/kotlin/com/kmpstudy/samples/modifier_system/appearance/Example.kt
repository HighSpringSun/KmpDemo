package com.kmpstudy.samples.modifier_system.appearance

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

@Composable
fun BackgroundExample() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 纯色背景
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
        )

        // 带形状的背景
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    color = Color.Red,
                    shape = RoundedCornerShape(16.dp)
                )
        )

        // 渐变背景
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color.Blue, Color.Green)
                    )
                )
        )
    }
}

@Composable
fun BorderExample() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 基础边框
        Box(
            modifier = Modifier
                .size(100.dp)
                .border(2.dp, Color.Blue)
        )

        // 带圆角的边框
        Box(
            modifier = Modifier
                .size(100.dp)
                .border(
                    width = 2.dp,
                    color = Color.Red,
                    shape = RoundedCornerShape(16.dp)
                )
        )

        // 虚线边框
        Box(
            modifier = Modifier
                .size(100.dp)
                .border(
                    width = 2.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(Color.Blue, Color.Green)
                    ),
                    shape = RoundedCornerShape(8.dp),
                )
        )
    }
}


@Composable
fun ShapeAndClipExample() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 圆形裁剪
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.Blue)
        )

        // 自定义圆角
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 0.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 16.dp
                    )
                )
                .background(Color.Red)
        )

        // 切角
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CutCornerShape(16.dp))
                .background(Color.Blue)
        )

        // 三角形
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(TriangleShape())
                .background(Color.Red)
        )
    }
}

// 可以通过实现Shape接口来实现自定义Shape，这个Shape可以用在对应的Modifier里
class TriangleShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            Path().apply {
                moveTo(size.width / 2f, 0f) // 顶点
                lineTo(size.width, size.height) // 右下角
                lineTo(0f, size.height) // 左下角
                close()
            }
        )
    }
}


@Composable
fun ShadowExample() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp)
            )
            .background(Color.White)
            .size(100.dp)
    )
}

@Composable
fun AlphaExample() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 不同透明度
        Box(
            modifier = Modifier
                .size(100.dp)
                .alpha(1f)
                .background(Color.Blue)
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .alpha(0.5f)
                .background(Color.Blue)
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .alpha(0.2f)
                .background(Color.Blue)
        )
    }
}


@Composable
fun CombinedEffectsExample() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .size(150.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text("组合效果")
    }
}

@Composable
fun SimpleToDoListItemExample() {
    val list = (1..6).map { "这是第${it}个简单的待办列表子项" }
    list.forEach { text ->
        SimpleToDoListItem(text = text)
    }
}

@Composable
fun SimpleToDoListItem(text: String) {
    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .fillMaxWidth()
            .height(60.dp)
            .shadow(4.dp, shape = RoundedCornerShape(8.dp))
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(8.dp)
            )
            .background(
                MaterialTheme.colorScheme.surface,
                RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(text)
    }
}

@Composable
fun CustomCardExample() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f),
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(16.dp)
            )
            .clip(RoundedCornerShape(16.dp))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                "卡片标题",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "卡片内容描述",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}