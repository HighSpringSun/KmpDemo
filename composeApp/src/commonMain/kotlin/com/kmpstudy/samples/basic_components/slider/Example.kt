package com.kmpstudy.samples.basic_components.slider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun SliderExamples() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // 基础滑块
        var sliderValue by remember { mutableStateOf(0f) }
        Text("基础滑块: ${sliderValue.toInt()}")
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = 0f..100f
        )

        // 带步长的滑块
        var stepSliderValue by remember { mutableStateOf(0f) }
        Text("步长滑块: ${stepSliderValue.toInt()}")
        Slider(
            value = stepSliderValue,
            onValueChange = { stepSliderValue = it },
            valueRange = 0f..100f,
            steps = 4
        )

        // 自定义滑块
        var customSliderValue by remember { mutableStateOf(0f) }
        Text("音量: ${(customSliderValue * 100).toInt()}%")
        Slider(
            value = customSliderValue,
            onValueChange = { customSliderValue = it },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.primary,
                activeTrackColor = MaterialTheme.colorScheme.primary,
                inactiveTrackColor = MaterialTheme.colorScheme.primaryContainer
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun RangeSliderExample() {
    Column(modifier = Modifier.padding(16.dp)) {
        var range by remember { mutableStateOf(0f..100f) }

        Text("价格区间: ¥${range.start.roundToInt()} - ¥${range.endInclusive.toInt()}")
        RangeSlider(
            value = range,
            onValueChange = { range = it },
            valueRange = 0f..100f,
            steps = 4
        )
    }
}

@Composable
fun MediaPlayerSlider() {
    var progress by remember { mutableStateOf(0f) }
    val duration = 180 // 假设总时长为180秒

    Column(modifier = Modifier.padding(16.dp)) {
        // 播放进度显示
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(formatTime((progress * duration).toInt()))
            Text(formatTime(duration))
        }

        // 进度条
        Slider(
            value = progress,
            onValueChange = { progress = it },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.primary,
                activeTrackColor = MaterialTheme.colorScheme.primary,
                inactiveTrackColor = MaterialTheme.colorScheme.surfaceVariant
            )
        )
    }
}

private fun formatTime(seconds: Int): String {
    val minutes = seconds / 60
    val remainingSeconds = seconds % 60
    return "$minutes:$remainingSeconds"
//    return String.format("%02d:%02d", minutes, remainingSeconds)
}