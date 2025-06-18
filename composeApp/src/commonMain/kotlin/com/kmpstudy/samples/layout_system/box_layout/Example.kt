package com.kmpstudy.samples.layout_system.box_layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.kmpstudy.CenterBox
import kmpdemo.composeapp.generated.resources.Res
import kmpdemo.composeapp.generated.resources.compose_multiplatform
import kmpdemo.composeapp.generated.resources.panda
import kmpdemo.composeapp.generated.resources.sun
import org.jetbrains.compose.resources.painterResource

@Composable
fun BasicBoxExample() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text("居中文本")
    }
}

@Composable
fun StackedBoxExample() {
    Box(
        modifier = Modifier.size(150.dp)
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Blue)
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.Center)
                .background(Color.White)
        )
        Text(
            text = "叠加文本",
            modifier = Modifier.align(Alignment.Center),
            color = Color.Black
        )
    }
}

@Composable
fun VerifiedProfilePicture(
    modifier: Modifier = Modifier,
    verifiedColor: Color = Color(86, 170, 140)
) {

    CenterBox(
        containerColor = Color.LightGray
    ) {
        CenterBox(
            modifier = Modifier
                .size(160.dp)
                .border(0.6.dp, Color.Gray.copy(0.8f)),
            containerColor = Color.White
        ) {
            Box(
                modifier = modifier
                    .size(120.dp),
                contentAlignment = Alignment.Center
            ) {
                // 显示圆形头像
                Image(
                    painter = painterResource(Res.drawable.panda),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                // 叠加勾选标记
                Icon(
                    imageVector = Icons.Filled.CheckCircle,
                    contentDescription = "Verified",
                    tint = verifiedColor,
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(Color.White, CircleShape)
                        .padding(0.5.dp)
                        .align(Alignment.BottomEnd)
                )
            }
        }
    }
}
