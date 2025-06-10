package com.kmpstudy.samples.compose_basics

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun Greeting(name: String) {
    Text("Hello,$name")
}