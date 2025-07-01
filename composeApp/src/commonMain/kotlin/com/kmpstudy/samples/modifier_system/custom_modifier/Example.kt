package com.kmpstudy.samples.modifier_system.custom_modifier

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CustomModifierExample() {
    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var isError by remember { mutableStateOf(false) }
        Text(
            "This is an example (shaking)",
            fontSize = 16.sp,
            modifier = Modifier
                .shakeOnError(isError)
        )

        Button(
            onClick = {
                isError = !isError
            }
        ) {
            Text("change")
        }
    }
    HorizontalDivider(
        modifier = Modifier,
    )
    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        var isError by remember { mutableStateOf(false) }
        Text(
            "This is an example (shimmer)",
            fontSize = 16.sp,
            modifier = Modifier
                .shimmerEffect()
        )
    }
    HorizontalDivider()
    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "This is an example (cardStyle)",
            fontSize = 16.sp,
            modifier = Modifier
                .cardStyle()
        )
    }
    HorizontalDivider()
    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "This is an example (borderAnimation)",
            fontSize = 16.sp,
            modifier = Modifier
                .borderAnimation()
                .padding(6.dp)
        )
    }
}


fun Modifier.cardStyle(
    color: Color = Color.LightGray,
    elevation: Dp = 4.dp,
    shape: Shape = RoundedCornerShape(8.dp)
) = this.then(
    Modifier
        .shadow(elevation, shape)
        .clip(shape)
        .background(color)
        .padding(16.dp)
)

fun Modifier.shimmerEffect(): Modifier = composed {
    var direction by remember { mutableStateOf(true) }
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f),
    )

    val transition = rememberInfiniteTransition()
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    background(
        brush = Brush.linearGradient(
            colors = shimmerColors,
            start = Offset.Zero,
            end = Offset(x = translateAnim.value, y = translateAnim.value)
        )
    )
}

fun Modifier.shakeOnError(isError: Boolean): Modifier = composed {
    val transition = updateTransition(isError, label = "shake")
    val offset by transition.animateDp(
        transitionSpec = {
            if (false isTransitioningTo true) {
                keyframes {
                    durationMillis = 500
                    0.dp at 0
                    10.dp at 100
                    (-10).dp at 200
                    10.dp at 300
                    (-10).dp at 400
                    0.dp at 500
                }
            } else {
                snap()
            }
        },
        label = "offset"
    ) { if (it) 0.dp else 0.dp }

    offset(x = offset)
}


fun Modifier.borderAnimation(
    borderWidth: Dp = 2.dp,
    borderColor: Color = Color.Red,
    animationDuration: Int = 1000
) = composed {
    val infiniteTransition = rememberInfiniteTransition()
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.2f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(animationDuration),
            repeatMode = RepeatMode.Reverse
        )
    )

    border(
        width = borderWidth,
        color = borderColor.copy(alpha = alpha),
        shape = RoundedCornerShape(8.dp)
    )
}


fun Modifier.gradientBackground(
    colors: List<Color>,
    angle: Float = 0f
) = composed {
    val angleRad = angle * PI / 180f
    val x = cos(angleRad).toFloat()
    val y = sin(angleRad).toFloat()

    background(
        brush = Brush.linearGradient(
            colors = colors,
            start = Offset(0f, 0f),
            end = Offset(x, y)
        )
    )
}

@Composable
fun GradientButtonExample() {
    Box(
        modifier = Modifier
            .gradientBackground(
                listOf(
                    MaterialTheme.colorScheme.primary,
                    MaterialTheme.colorScheme.secondary
                ),
                45f
            ),
        contentAlignment = Alignment.Center
    ) {
        Text("渐变按钮")
    }
}