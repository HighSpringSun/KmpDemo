package com.kmpstudy.samples.basic_components.text_and_button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextExamples() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // 基础文本
        Text("基础文本!")

        // 自定义样式
        Text(
            text = "自定义样式文本",
            color = Color.Blue,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        // 多行文本
        Text(
            text = "这是一段较长的文本内容，用于演示文本换行和截断功能。",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .width(200.dp)
        )
    }
}


@Composable
fun RichTextExample() {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold)) {
                append("这是一段")
            }
            append("普通文本")
            withStyle(style = SpanStyle(color = Color.Red, fontStyle = FontStyle.Italic)) {
                append("，包含了")
            }
            withStyle(
                style = SpanStyle(
                    color = Color.Gray,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("多种样式")
            }
            append("。")
        }
    )
}

@Composable
fun ButtonExamples() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 标准按钮
        Button(
            onClick = { /* 处理点击事件 */ }
        ) {
            Text("标准按钮")
        }

        // 轮廓按钮
        OutlinedButton(
            onClick = { /* 处理点击事件 */ }
        ) {
            Text("轮廓按钮")
        }

        // 文本按钮
        TextButton(
            onClick = { /* 处理点击事件 */ }
        ) {
            Text("文本按钮")
        }

        // 带图标的按钮
        Button(
            onClick = { /* 处理点击事件 */ }
        ) {
//            Icon(
//                imageVector = Icons.Default.Send,
//                contentDescription = null,
//                modifier = Modifier.size(24.dp)
//            )
            Spacer(Modifier.width(8.dp))
            Text("发送")
        }
    }
}