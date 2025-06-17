package com.kmpstudy.samples.compose_fundamentals.compose_basics

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Greeting(name: String) {
    Text(text = "Hello, $name!") // 声明式：只需描述UI内容
}