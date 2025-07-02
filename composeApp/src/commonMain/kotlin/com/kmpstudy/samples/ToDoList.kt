package com.kmpstudy.samples

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kmpstudy.CenterBox
import kmpdemo.composeapp.generated.resources.Res
import kmpdemo.composeapp.generated.resources.tie_dog
import org.jetbrains.compose.resources.painterResource


@Composable
fun MainScreen() {
    var checked by remember { mutableStateOf(true) }
    val animatedBlur by animateDpAsState(targetValue = if (checked) 10.dp else 0.dp)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.blur(
                radius = animatedBlur,
                edgeTreatment = BlurredEdgeTreatment.Unbounded
            ),
            text = "Hello World",
            fontSize = MaterialTheme.typography.displayLarge.fontSize
        )
        Spacer(modifier = Modifier.height(24.dp))
        Switch(checked = checked, onCheckedChange = { checked = !checked })
    }
}


@Composable
fun GroundGlass() {
    CenterBox {
        Box(
            modifier = Modifier
                .size(300.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painterResource(Res.drawable.tie_dog),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )


            Box(
                modifier = Modifier
                    .size(240.dp)
//                    .border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
                    .blur(5.dp, BlurredEdgeTreatment.Unbounded)
                    .graphicsLayer {
//                        renderEffect = ImageShader()
                    }
                    .background(Color.White.copy(alpha = 0.5f), RoundedCornerShape(12.dp)) // 半透明白色

            ) {
//                Text("123321")
            }

//            // 图标层
//            Box(
//                modifier = Modifier
//                    .size(120.dp)
//                    .align(Alignment.Center)
//                    .background(Color.Green.copy(alpha = 0.4f), RoundedCornerShape(12.dp)) // 绿色方块
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Edit,
//                    contentDescription = "Edit Icon",
//                    tint = Color.White,
//                    modifier = Modifier.align(Alignment.Center)
//                )
//            }
        }
    }
}


@Composable
fun AnimHeader(delay: Int) {
    AnimBase(0.5f, 330f, delay, Color.White, {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 显示圆形头像
            Image(
                painter = painterResource(Res.drawable.tie_dog),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Tie Dog",
                fontSize = 16.sp
            )
        }
    })
}

@Composable
fun AnimBackground(delay: Int, color: Color) {
    AnimBase(1f, 150f, delay, color, {})
}

@Composable
fun AnimBase(
    targetSize: Float,
    targetAngle: Float,
    delay: Int,
    color: Color,
    content: @Composable () -> Unit
) {
    var sizeValue by remember { mutableStateOf(0f) }
    var angleValue by remember { mutableStateOf(30f) }
    val size by animateFloatAsState(
        sizeValue,
        animationSpec = tween(durationMillis = 1400, delayMillis = delay)
    ) // 动画时长为 1 秒)
    val angle by animateFloatAsState(
        angleValue,
        animationSpec = tween(durationMillis = 1400, delayMillis = delay)
    ) // 动画时长为 1 秒)

    LaunchedEffect(Unit) {
        sizeValue = targetSize
        angleValue += targetAngle
    }
    Box(
        modifier = Modifier
            .fillMaxSize(size)
            .rotate(angle)
            .clip(RoundedCornerShape(12.dp))
            .background(color, RoundedCornerShape(12.dp))
    ) {
        content()
    }
}

@Composable
fun AnimText() {
    CenterBox {
        Box(
            modifier = Modifier,
            contentAlignment = Alignment.Center
        ) {
            Text("123")
            var value by remember { mutableStateOf(0) }
            val offset by animateIntAsState(value, tween(1500))
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .offset(offset.dp, 0.dp)
                    .background(Color.White)
                    .clickable {
                        value = if (value == 0) {
                            100
                        } else {
                            0
                        }
                    }
            )
        }
    }
}