package com.kmpstudy.samples.modifier_system.interaction

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun ClickableExample() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 基础点击
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.Blue)
                .clickable { /* 处理点击 */ }
        )

        // 带涟漪效果的点击
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.Red)
                .clip(RoundedCornerShape(8.dp))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = LocalIndication.current
                ) { /* 处理点击 */ }
        )

        // 禁用状态
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Gray)
                .clickable(
                    enabled = false,
                    onClick = { /* 处理点击 */ }
                )
        )
    }
}


@Composable
fun GestureExample() {
    var offset by remember { mutableStateOf(Offset.Zero) }

    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.LightGray)
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .offset { IntOffset(offset.x.roundToInt(), offset.y.roundToInt()) }
                .background(Color.Blue)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        offset += dragAmount
                    }
                }
        )
    }
}