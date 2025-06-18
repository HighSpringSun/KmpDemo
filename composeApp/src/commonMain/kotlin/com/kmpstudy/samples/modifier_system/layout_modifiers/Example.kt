package com.kmpstudy.samples.modifier_system.layout_modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PositionExample() {
    Box(
        modifier =
            Modifier
                .padding(8.dp)
                .size(400.dp)
                .border(1.dp, Color.Black)
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
                .align(Alignment.TopStart),
            contentAlignment = Alignment.Center
        ) {
            Text("TopStart", color = Color.White, fontSize = 16.sp)
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
                .align(Alignment.TopCenter),
            contentAlignment = Alignment.Center
        ) {
            Text("TopCenter", color = Color.White, fontSize = 16.sp)
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
                .align(Alignment.TopEnd),
            contentAlignment = Alignment.Center
        ) {
            Text("TopEnd", color = Color.White, fontSize = 16.sp)
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .align(Alignment.CenterStart),
            contentAlignment = Alignment.Center
        ) {
            Text("CenterStart", color = Color.White, fontSize = 16.sp)
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .align(Alignment.Center),
            contentAlignment = Alignment.Center
        ) {
            Text("Center", color = Color.White, fontSize = 16.sp)
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .align(Alignment.CenterEnd),
            contentAlignment = Alignment.Center
        ) {
            Text("CenterEnd", color = Color.White, fontSize = 16.sp)
        }


        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
                .align(Alignment.BottomStart),
            contentAlignment = Alignment.Center
        ) {
            Text("BottomStart", color = Color.Black, fontSize = 16.sp)
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
                .align(Alignment.BottomCenter),
            contentAlignment = Alignment.Center
        ) {
            Text("BottomCenter", color = Color.Black, fontSize = 16.sp)
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
                .align(Alignment.BottomEnd),
            contentAlignment = Alignment.Center
        ) {
            Text("BottomEnd", color = Color.Black, fontSize = 16.sp)
        }
    }
}

@Composable
fun OffsetExample() {
    Column(
        modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // 相对偏移
        // 将内容偏移（x dp，y dp）。偏移量可以是正的，也可以是非正的。应用偏移只会改变内容的位置，而不会干扰其大小测量。
        // 此修改器将根据布局方向自动调整水平偏移：当布局方向为LTR时，正的x偏移将使内容向右移动，当布局方向是RTL时，正x偏移将将使内容向左移动。对于不考虑布局方向而偏移的修改器，请参见absoluteOffset。
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.LightGray)
                .offset(x = 20.dp, y = 20.dp)
                .background(Color.Blue)
                .clickable { }
        )

        // 绝对偏移
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.LightGray)
                .absoluteOffset(x = 20.dp, y = 20.dp)
                .background(Color.Red)
                .clickable { }
        )
    }
}


@Composable
fun ConstraintsExample() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 最小尺寸约束
        Box(
            modifier = Modifier
                .defaultMinSize(minWidth = 100.dp, minHeight = 50.dp)
                .background(Color.Blue)
        )

        // 包裹内容
        Box(
            modifier = Modifier
                .wrapContentSize()
                .background(Color.Red)
        ) {
            Text("自适应内容大小")
        }

        // 填充父容器
        Box(
            modifier = Modifier
                .fillMaxSize(0.5f) // 填充父容器50%
                .background(Color.Green),
            contentAlignment = Alignment.Center
        ) {
            Text("注意是填充父控件剩余大小的50%")
        }
    }
}


@Composable
fun WeightAndRatioExample() {
    Column(modifier = Modifier.fillMaxHeight()) {
        // 权重布局
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
                    .background(Color.Blue)
            )
            Box(
                modifier = Modifier
                    .weight(2f)
                    .height(50.dp)
                    .background(Color.Red)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 宽高比
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f)
                .background(Color.Green)
        )
    }
}