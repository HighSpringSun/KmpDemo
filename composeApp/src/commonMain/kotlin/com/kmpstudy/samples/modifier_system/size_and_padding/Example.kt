package com.kmpstudy.samples.modifier_system.size_and_padding

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SizeModifierExample() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 固定大小
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
        )

        // 单独设置宽高
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(50.dp)
                .background(Color.Red)
        )

        // 设置最大最小尺寸
        Box(
            modifier = Modifier
                .widthIn(min = 100.dp, max = 200.dp)
                .heightIn(min = 50.dp, max = 100.dp)
                .background(Color.Green)
        )
    }
}


@Composable
fun FillSizeExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 填充宽度
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Blue)
        )

        // 填充高度
        Box(
            modifier = Modifier
                .fillMaxHeight(0.3f) // 填充30%的高度
                .width(100.dp)
                .background(Color.Red)
        )

        // 按比例填充
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f) // 填充50%的宽度
                .height(50.dp)
                .background(Color.Green)
        )
    }
}


@Composable
fun PaddingExample() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        // 所有方向相同的内边距
        Box(
            modifier = Modifier
                .border(1.dp, Color.Black)
                .padding(16.dp)
                .background(Color.Green)
                .size(100.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 水平和垂直方向不同的内边距
        Box(
            modifier = Modifier
                .border(1.dp, Color.Black)
                .padding(horizontal = 64.dp, vertical = 8.dp)
                .background(Color.Green)
                .size(100.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 分别设置各个方向的内边距
        Box(
            modifier = Modifier
                .border(1.dp, Color.Black)
                .padding(start = 8.dp, top = 64.dp, end = 48.dp, bottom = 8.dp)
                .background(Color.Green)
                .size(100.dp)
        )
    }
}


@Composable
fun MarginExample() {
    Box(
        modifier = Modifier
            .padding(start = 4.dp)
            .border(1.dp, Color.Black)
            .padding(48.dp)
            .border(1.dp, Color.Black)
            .padding(16.dp)
            .size(120.dp)
    ) {
        Text(
            """
            在Modifier修饰符中没有Margin,
            取决于padding和size的位置
        """.trimIndent()
        )
    }
}

@Composable
fun AspectRatioExample() {
    Box(
        modifier = Modifier
            .width(160.dp)
            .aspectRatio(16f / 9f) // 16:9 宽高比
            .background(Color.Green)
    )
}

@Composable
fun WeightExample() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(50.dp)
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .weight(2f)
                .height(50.dp)
                .background(Color.Blue)
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .height(50.dp)
                .background(Color.Green)
        )
    }
}

@Composable
fun ClickableCircleAvatar() {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    // 按钮背景颜色随点击状态变化
    val backgroundColor by animateColorAsState(
        targetValue = if (isPressed) Color.Red else Color.Red.copy(0.5f),
        label = "Background color animation"
    )

    Box(
        modifier = Modifier
            .padding(start = 8.dp, top = 8.dp)
            .width(200.dp)
            .height(60.dp)
            .clip(RoundedCornerShape(0.dp, 8.dp, 0.dp, 8.dp))
            .shadow(elevation = 3.dp)
            .background(backgroundColor)
            .clickable(interactionSource = interactionSource, indication = null) {
                // 点击事件
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Modifier",
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        )
    }
}