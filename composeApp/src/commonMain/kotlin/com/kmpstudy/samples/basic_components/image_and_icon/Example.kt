package com.kmpstudy.samples.basic_components.image_and_icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kmpdemo.composeapp.generated.resources.Res
import kmpdemo.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource

@Composable
fun ImageExamples() {
    Column(modifier = Modifier.padding(16.dp)) {
        // 从资源加载图片
        Image(
            painter = painterResource(Res.drawable.compose_multiplatform),
            contentDescription = "示例图片",
            modifier = Modifier.size(200.dp)
        )

        // 从网络加载图片
        AsyncImage(
            model = "https://compose.funnysaltyfish.fun/assets/images/tutorial-banner-b9fc57ac10af4659b42fa6049a0c45b7.png",
            contentDescription = "网络图片",
            modifier = Modifier.size(400.dp, 200.dp)
        )

        // 自定义图片显示方式
        Image(
            painter = painterResource(Res.drawable.compose_multiplatform),
            contentDescription = "裁剪的图片",
            contentScale = ContentScale.Crop,
            alpha = 0.3f,
            modifier = Modifier
                .size(150.dp)
        )
    }
}

@Composable
fun ImageScaleExamples() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 默认显示
        Image(
            painter = painterResource(Res.drawable.compose_multiplatform),
            contentDescription = "填充模式",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(width = 100.dp, height = 200.dp)
                .border(1.dp, Color.LightGray)
        )

        // 填充显示
        Image(
            painter = painterResource(Res.drawable.compose_multiplatform),
            contentDescription = "填充模式",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(width = 100.dp, height = 200.dp)
                .border(1.dp, Color.LightGray)
        )

        // 适应显示
        Image(
            painter = painterResource(Res.drawable.compose_multiplatform),
            contentDescription = "适应模式",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(width = 100.dp, height = 200.dp)
                .border(1.dp, Color.LightGray)
        )

        // 裁剪显示
        Image(
            painter = painterResource(Res.drawable.compose_multiplatform),
            contentDescription = "裁剪模式",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 100.dp, height = 200.dp)
                .border(1.dp, Color.LightGray)
        )
    }
}