package com.kmpstudy.samples.basic_components.image_and_icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kmpdemo.composeapp.generated.resources.Res
import kmpdemo.composeapp.generated.resources.compose_multiplatform
import kmpdemo.composeapp.generated.resources.compose_multiplatform_logo
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

@Composable
fun IconExamples() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Material 图标
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "收藏",
            tint = Color.Red
        )

        // 自定义大小的图标
        Icon(
            imageVector = Icons.Default.Share,
            contentDescription = "分享",
            modifier = Modifier.size(32.dp),
            tint = Color.Blue
        )

        // 使用画笔的图标
        Icon(
            painter = painterResource(Res.drawable.compose_multiplatform_logo),
            contentDescription = "自定义图标",
            tint = Color.Unspecified
        )
    }
}


@Composable
fun CommonIconsExample() {
    Column(
        modifier = Modifier.height(400.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(Icons.Default.Home, "首页")
        Icon(Icons.Default.Settings, "设置")
        Icon(Icons.Default.Person, "个人")
        Icon(Icons.Default.Menu, "菜单")
    }
}