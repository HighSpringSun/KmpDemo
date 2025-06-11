package com.kmpstudy.samples.modifier_system.modifier_basics

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


/**
 * 一个用于演示 Compose 中 [Modifier] 基本用法的可组合函数。
 *
 * 此示例展示了如何使用多个修饰符来控制组件的：
 * - 边框（[border]）
 * - 内边距（[padding]）
 * - 背景颜色与形状（[background]）
 *
 * 注意：Modifier 是链式调用的，顺序会影响最终效果。
 */
@Composable
fun ModifierBasicExample() {
    // 显示文本 "Hello Compose"
    Text(
        text = "Hello Compose", // 要显示的文本内容

        // 使用 Modifier 来定义外观和布局行为
        modifier = Modifier
            // 添加宽度为 1.dp、颜色为黑色的边框
            .border(width = 1.dp, color = Color.Black)

            // 设置组件内部与文字之间的内边距为 16.dp
            .padding(16.dp)

            // 设置背景颜色为红色，并设置圆角矩形形状（4.dp 圆角半径）
            .background(
                color = Color.Red,
                shape = RoundedCornerShape(4.dp)
            )
    )
}


@Composable
fun ChainCallExample() {
    // 使用 Box 容器包裹 Text 组件
    Box(
        modifier = Modifier
            // 1. 设置组件的宽度和高度为 200.dp（形成一个正方形）
            .size(200.dp)

            // 2. 添加黑色边框，宽度为 1.dp
            //    此时边框将包裹整个 200x200 dp 的区域
            .border(width = 1.dp, color = Color.Black)

            // 3. 在内容周围添加 16.dp 的内边距（padding）
            //    padding 会影响子元素的位置，并可能影响后续修饰符的效果范围
            .padding(16.dp)

            // 4. 设置半透明红色背景（alpha = 0.5），仅覆盖当前修饰链中前面定义的区域
            //    因为它在第一个 padding 后面，所以背景会包含这个 padding 区域
            .background(Color.Red.copy(alpha = 0.5f))

            // 5. 再次添加 16.dp 的内边距
            //    这个 padding 会影响 Text 的位置，并且不会被上一步的 background 覆盖
            .padding(16.dp)

            // 6. 再次添加黑色边框
            //    这个边框包裹的是经过两次 padding 后的内容区域
            .border(width = 1.dp, color = Color.Black)
    ) {
        Text("顺序很重要", color = Color.White)
    }
}

@Composable
fun OrderComparisonExample() {
    Column(modifier = Modifier.padding(16.dp)) {
        // 示例 1：先设置背景，再添加内边距
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .padding(16.dp)
                .size(100.dp)
        ) {
            Text("背景在内边距下", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 示例 2：先添加内边距，再设置背景
        Box(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Blue)
                .size(100.dp)
        ) {
            Text("内边距在背景下", color = Color.White)
        }
    }
}

@Composable
fun ScopeExample() {
    Row(
        // RowScope 中的修饰符
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            // 只在 Box 中生效的修饰符
            modifier = Modifier
                .weight(1f)  // 只在 Row/Column 作用域中有效
                .align(Alignment.CenterVertically)  // 只在 Row 作用域中有效
        )
    }
}

@Composable
fun CardStyleExample() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surface)
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(8.dp)
            )
            .clickable { /* 处理点击 */ }
            .padding(16.dp)
    ) {
        Text("卡片内容")
    }
}